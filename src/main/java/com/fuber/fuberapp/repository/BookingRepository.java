package com.fuber.fuberapp.repository;

import com.fuber.fuberapp.pojo.CabBooking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingRepository {



    private static Map<Long, CabBooking> bookingDB= new HashMap<>();


    private Long getId(){
        return Long.valueOf(bookingDB.size()+1);
    }


    public CabBooking addBooking(CabBooking booking) {
        booking.setId(getId());
        bookingDB.put(booking.getId(),booking);
        return booking;
    }


    public CabBooking deleteBooking(Long id) {
        CabBooking booking =new CabBooking();
        booking.setId(id);
        CabBooking bookingFromDb=bookingDB.get(booking);
        return null!=bookingFromDb?bookingDB.remove(booking):null;

    }


    public CabBooking getBookingDetail(Long id) {
        CabBooking booking =new CabBooking();
        booking.setId(id);
        CabBooking bookingFromDb=bookingDB.get(booking);
        return bookingFromDb;
    }

    public List<CabBooking> getBookings() {
        List<CabBooking> bookingList=new ArrayList<>();
        for(Map.Entry<Long, CabBooking> entry:bookingDB.entrySet()){
            bookingList.add(entry.getValue());
        }
        return bookingList;
    }

    public CabBooking updateBookingDetail(CabBooking booking, Long bookingId) {
        booking.setId(bookingId);
        CabBooking bookingFromDb=bookingDB.get(booking);
        return null!=bookingFromDb?bookingDB.put(booking.getId(),booking):null;
    }


}
