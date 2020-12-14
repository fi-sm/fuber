package com.fuber.fuberapp.controller;

import com.fuber.fuberapp.pojo.Driver;
import com.fuber.fuberapp.repository.DriverRepository;
import com.fuber.fuberapp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DriverService driverService;

    @PostMapping(value = "/driver")
    public GenericResponse<Driver> createDriver(@RequestBody Driver driver, @RequestHeader(required = true)
            String idToken)  {
        return new GenericResponse<>(driverService.addDriver(driver), HttpStatus.CREATED);
    }

    @GetMapping(value = "/driver")
    public GenericResponse<List<Driver>> getDrivers(@RequestHeader(required = true) String idToken)  {
        LOGGER.info("Loading driver...");
        List<Driver> list=driverService.getDrivers();
        return new GenericResponse<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/driver/{id}")
    public GenericResponse<Driver> getDriverById(@PathVariable("id") Integer id, @RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(driverService.getDriverDetail(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/driver/{id}")
    public GenericResponse<Driver> DeleteDriverById(@PathVariable("id") Integer id, @RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(driverService.deleteDriver(id), HttpStatus.OK);
    }

    @PutMapping(value= "/driver/{id}")
    public GenericResponse<Driver> modifyDriver(@RequestBody Driver driver ,
                                                 @RequestHeader(required = true) String idToken, @PathVariable("id") Integer id)
    {
        LOGGER.info("driver id to be updated");
        return new GenericResponse<>(driverService.updateDriverDetail(driver,id), HttpStatus.OK);
    }
}
