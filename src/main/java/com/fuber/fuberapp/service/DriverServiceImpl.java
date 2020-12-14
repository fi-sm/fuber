package com.fuber.fuberapp.service;

import com.fuber.fuberapp.pojo.Driver;
import com.fuber.fuberapp.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverServiceImpl implements  DriverService{
    @Autowired
    private DriverRepository driverRepository;



    @Override
    public Driver addDriver(Driver driver) {
        return driverRepository.addDriver(driver);
    }

    @Override
    public Driver deleteDriver(Integer driver) {
        return driverRepository.deleteDriver(driver);
    }

    @Override
    public Driver getDriverDetail(Integer driver) {
        return driverRepository.getDriverDetail(driver);
    }

    @Override
    public List<Driver> getDrivers() {
        return driverRepository.getDrivers();
    }

    @Override
    public Driver updateDriverDetail(Driver driver, Integer driverId) {
        return driverRepository.updateDriverDetail(driver,driverId);
    }
}
