package com.fuber.fuberapp.controller;

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

    @PostMapping(value = "/cab")
    public GenericResponse<String> createCabs(@RequestBody String cab, @RequestHeader(required = true)
            String idToken)  {
        return new GenericResponse<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/cab")
    public GenericResponse<List<String>> getCabs(@RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/cab/{id}")
    public GenericResponse<String> getCabsById(@PathVariable("id") Long id, @RequestHeader(required = true) String idToken)  {
        return new GenericResponse<>(null, HttpStatus.OK);
    }

    @PutMapping(value= "/cab/{id}")
    public GenericResponse<String> modifyCabs(@RequestBody String cab ,
                                                 @RequestHeader(required = true) String idToken, @PathVariable("id") Long id)
    {
        LOGGER.info("cab id to be updated");
        return new GenericResponse<>(null, HttpStatus.OK);
    }
}
