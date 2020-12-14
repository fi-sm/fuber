package com.fuber.fuberapp.controller;

import com.fuber.fuberapp.pojo.CabBooking;
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



    @PostMapping(value = "/booking")
    public GenericResponse<String> bookingRequest(@RequestBody CabBooking booking, @RequestHeader(required = true)
            String idToken)  {
        return new GenericResponse<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/booking")
    public GenericResponse<List<String>> getBookings(@RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/booking/{id}")
    public GenericResponse<String> getBookingById(@PathVariable("id") Long id, @RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(null, HttpStatus.OK);
    }

    @PutMapping(value= "/booking/{id}")
    public GenericResponse<String> modifyBooking(@RequestBody String booking ,
                                                 @RequestHeader(required = true) String idToken, @PathVariable("id") Long id)
            {
        LOGGER.info("booking id to be updated");
        return new GenericResponse<>(null, HttpStatus.OK);
    }





}


