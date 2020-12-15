package com.fuber.fuberapp.controller;

import com.fuber.fuberapp.pojo.Cab;
import com.fuber.fuberapp.pojo.CabWithDistance;
import com.fuber.fuberapp.pojo.Location;
import com.fuber.fuberapp.service.CabService;
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
public class CabsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CabsController.class);

    @Autowired
    private CabService cabService;
    @PostMapping(value = "/cab")
    public GenericResponse<Cab> createCabs(@RequestBody Cab cab, @RequestHeader(required = true)
            String idToken)  {
        return new GenericResponse<>(cabService.addCab(cab), HttpStatus.CREATED);
    }

    @GetMapping(value = "/cab")
    public GenericResponse<List<Cab>> getCabs(@RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(cabService.getCabs(), HttpStatus.OK);
    }

    @GetMapping(value = "/cab/{id}")
    public GenericResponse<Cab> getCabsById(@PathVariable("id") Integer id, @RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(cabService.getCabDetail(id), HttpStatus.OK);
    }

    @GetMapping(value = "/cab/available")
    public GenericResponse<List<CabWithDistance>> findAvailableCabs(@RequestHeader(required = true) String idToken,
                                                                    @RequestParam(value = "longitude") Long longitude ,
                                                                    @RequestParam(value = "latitude") Long latitude,
                                                                    @RequestParam(value = "color") String color)  {
        CabWithDistance cab=new CabWithDistance();
        cab.setColor(color);
        cab.setLongitude(longitude);
        cab.setLatitude(latitude);

        return new GenericResponse<>(cabService.findAvailableCabs(cab), HttpStatus.OK);
    }


    @PutMapping(value= "/cab/{id}")
    public GenericResponse<Cab> modifyCabs(@RequestBody Cab cab ,
                                                 @RequestHeader(required = true) String idToken, @PathVariable("id") Integer id)
    {
        LOGGER.info("cab id to be updated");
        return new GenericResponse<>(cabService.updateCabDetail(cab,id), HttpStatus.OK);
    }
}
