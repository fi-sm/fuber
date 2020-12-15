package com.fuber.fuberapp.service;

import com.fuber.fuberapp.pojo.BookingRequest;
import com.fuber.fuberapp.pojo.CabBooking;
import com.fuber.fuberapp.pojo.TripStage;

import java.util.List;

public interface CabBookingService {

    CabBooking processBookingRequest(BookingRequest cabBooking);
    CabBooking updateTripStage(TripStage tripStage );
    CabBooking getCabBookingDetail(Long id);
    List<CabBooking> allBookings();

}
