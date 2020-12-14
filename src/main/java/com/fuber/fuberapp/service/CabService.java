package com.fuber.fuberapp.service;

import com.fuber.fuberapp.pojo.Cab;
import com.fuber.fuberapp.pojo.CabWithDistance;

import java.util.List;

public interface CabService {


    Cab addCab(Cab cab);
    Cab deleteCab(Integer id);
    Cab getCabDetail(Integer id);
    List<Cab> getCabs();
    List<CabWithDistance> findAvailableCabs(CabWithDistance cabWithDistance);
    Cab updateCabDetail(Cab cab,Integer id);
}
