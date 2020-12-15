package com.fuber.fuberapp.controller;

import com.fuber.fuberapp.pojo.BookingRequest;
import com.fuber.fuberapp.pojo.CabBooking;
import com.fuber.fuberapp.pojo.TripStage;
import com.fuber.fuberapp.service.CabBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.fuber.fuberapp.pojo.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CabBookingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CabBookingController.class);

    @Autowired
    private CabBookingService cabBookingService;


    @PostMapping(value = "/booking")
    public GenericResponse<CabBooking> bookingRequest(@RequestBody BookingRequest booking, @RequestHeader(required = true)
            String idToken)  {
        return new GenericResponse<>(cabBookingService.processBookingRequest(booking), HttpStatus.CREATED);
    }

    @GetMapping(value = "/booking")
    public GenericResponse<List<CabBooking>> getBookings(@RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(cabBookingService.allBookings(), HttpStatus.OK);
    }

    @GetMapping(value = "/booking/{id}")
    public GenericResponse<CabBooking> getBookingById(@PathVariable("id") Long id, @RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(cabBookingService.getCabBookingDetail(id), HttpStatus.OK);
    }

    @PutMapping(value= "/booking/{id}")
    public GenericResponse<CabBooking> updateTripStage(@RequestBody TripStage tripStage ,
                                                 @RequestHeader(required = true) String idToken, @PathVariable("id") Long id)
            {
        return new GenericResponse<>(cabBookingService.updateTripStage(tripStage), HttpStatus.OK);
    }





}


