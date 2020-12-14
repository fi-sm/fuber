package com.fuber.fuberapp.service;


import com.fuber.fuberapp.pojo.Cab;
import com.fuber.fuberapp.repository.CabRepository;
import com.fuber.fuberapp.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabServiceImpl implements CabService{


    @Autowired
    private CabRepository cabRepository;

    @Override
    public Cab addCab(Cab cab) {
        return cabRepository.addCab(cab);
    }

    @Override
    public Cab deleteCab(Integer id) {
        return cabRepository.deleteCab(id);
    }

    @Override
    public Cab getCabDetail(Integer id) {
        return cabRepository.getCabDetail(id);
    }

    @Override
    public List<Cab> getCabs() {
        return cabRepository.getCabs();
    }

    @Override
    public Cab updateCabDetail(Cab cab, Integer id) {
        return cabRepository.updateCabDetail(cab,id);
    }
}
