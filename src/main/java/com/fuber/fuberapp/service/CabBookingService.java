package com.fuber.fuberapp.service;

import com.fuber.fuberapp.pojo.CabBooking;

public interface CabBookingService {

    CabBooking processBookingRequest(CabBooking cabBooking);
    CabBooking createBooking(CabBooking cabBooking);
    CabBooking updateTripStage(CabBooking cabBooking);

}
