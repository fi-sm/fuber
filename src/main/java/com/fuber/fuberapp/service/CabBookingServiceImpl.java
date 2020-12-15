package com.fuber.fuberapp.service;

import com.fuber.fuberapp.pojo.BookingRequest;
import com.fuber.fuberapp.pojo.CabBooking;
import com.fuber.fuberapp.pojo.CabWithDistance;
import com.fuber.fuberapp.pojo.TripStage;
import com.fuber.fuberapp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CabBookingServiceImpl  implements CabBookingService{


    @Autowired
    private CabService cabService;

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public CabBooking processBookingRequest(BookingRequest cabBooking) {
        CabWithDistance  cabWithDistance=new CabWithDistance();
        cabWithDistance.setColor(cabBooking.getColor());
        cabWithDistance.setLatitude(cabBooking.getSourceLocation().getLatitude());
        cabWithDistance.setLongitude(cabBooking.getSourceLocation().getLongitude());
       List<CabWithDistance>  cabsWithDistance= cabService.findAvailableCabs(cabWithDistance);
        CabBooking cbooking=new CabBooking();
       if(null!=cabsWithDistance && cabsWithDistance.size()>0){
           CabWithDistance cWithDistance=cabsWithDistance.get(0);

           cbooking.setSourceLocation(cabBooking.getSourceLocation());
           cbooking.setDestinationLocation(cabBooking.getDestinationLocation());
           cbooking.setWithCab(cabService.getCabDetail(cWithDistance.getCabId()));
           cbooking.getWithCab().setIsAvailable("N");
           cbooking.setBookingTime(LocalDateTime.now());
           cbooking.setIsCompleted(getStage("Booked"));
           bookingRepository.addBooking(cbooking);
       }
        return cbooking;
    }

    @Override
    public CabBooking updateTripStage(TripStage tripStage) {
        CabBooking cbooking=null;
        switch(tripStage.getStage()){
            case "STARTED" : {
                 cbooking=bookingRepository.getBookingDetail(tripStage.getBookingId());
                 cbooking.setTripStartTime(LocalDateTime.now());
                cbooking.setIsCompleted(getStage("Started"));
                bookingRepository.updateBookingDetail(cbooking,cbooking.getId());
                break;
            }
            case "COMPLETED":{
                cbooking=bookingRepository.getBookingDetail(tripStage.getBookingId());
                cbooking.setTripEndTime(LocalDateTime.now());
                cbooking.setIsCompleted(getStage("Completed"));
                cbooking.getWithCab().setIsAvailable("Y");
                cabService.updateCabDetail(cbooking.getWithCab(),cbooking.getWithCab().getId());
                break;
            }
        }
        return cbooking;
    }

    @Override
    public CabBooking getCabBookingDetail(Long id) {
        return bookingRepository.getBookingDetail(id);
    }

    @Override
    public List<CabBooking> allBookings() {
        return bookingRepository.getBookings();
    }

    private String getStage(String stage){
        return stage.toUpperCase();
    }


}
