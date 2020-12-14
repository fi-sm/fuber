package com.fuber.fuberapp.service;

import com.fuber.fuberapp.pojo.Driver;

import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver);
    Driver deleteDriver(Integer driver);
    Driver getDriverDetail(Integer driver);
    List<Driver> getDrivers();
    Driver updateDriverDetail(Driver driver,Integer driverId);
}

