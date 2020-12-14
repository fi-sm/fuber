package com.fuber.fuberapp.repository;

import com.fuber.fuberapp.pojo.Driver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DriverRepository {

    private static Map<Driver, Driver> driverDb= new HashMap<>();


    private Integer getId(){
        return driverDb.size()+1;
    }


    public Driver addDriver(Driver driver) {
         driver.setId(getId());
         driverDb.put(driver,driver);
        return driver;
    }


    public Driver deleteDriver(Integer id) {
        Driver driver =new Driver();
        driver.setId(id);
        Driver driverFromDb=driverDb.get(driver);
        return null!=driverFromDb?driverDb.remove(driver):null;

    }


    public Driver getDriverDetail(Integer id) {
        Driver driver =new Driver();
        driver.setId(id);
        Driver driverFromDb=driverDb.get(driver);
        return driverFromDb;
    }

    public List<Driver> getDrivers() {
        List<Driver> driverList=new ArrayList<>();
        for(Map.Entry<Driver,Driver> entry:driverDb.entrySet()){
            driverList.add(entry.getValue());
        }
        return driverList;
    }

    public Driver updateDriverDetail(Driver driver, Integer driverId) {
        driver.setId(driverId);
        Driver driverFromDb=driverDb.get(driver);
         return null!=driverFromDb?driverDb.put(driver,driver):null;
    }
}
