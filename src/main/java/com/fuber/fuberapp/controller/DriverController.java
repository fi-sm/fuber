package com.fuber.fuberapp.controller;

import org.springframework.web.bind.annotation.RestController;
import com.fuber.fuberapp.pojo.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DriverController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverController.class);


    @PostMapping(value = "/driver")
    public GenericResponse<String> createDriver(@RequestBody String driver, @RequestHeader(required = true)
            String idToken)  {
        return new GenericResponse<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/driver")
    public GenericResponse<List<String>> getDrivers(@RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/driver/{id}")
    public GenericResponse<String> getDriverById(@PathVariable("id") Long id, @RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(null, HttpStatus.OK);
    }

    @PutMapping(value= "/driver/{id}")
    public GenericResponse<String> modifyDriver(@RequestBody String driver ,
                                                 @RequestHeader(required = true) String idToken, @PathVariable("id") Long id)
    {
        LOGGER.info("driver id to be updated");
        return new GenericResponse<>(null, HttpStatus.OK);
    }
}
