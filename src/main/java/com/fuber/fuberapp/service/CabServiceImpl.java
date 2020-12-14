package com.fuber.fuberapp.service;


import com.fuber.fuberapp.pojo.Cab;
import com.fuber.fuberapp.pojo.CabWithDistance;
import com.fuber.fuberapp.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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



    @Override
    public List<CabWithDistance> findAvailableCabs(CabWithDistance cabWithDistance) {
        List<Cab> cabs=getCabs();
        List<CabWithDistance> cabsWithDistance=cabs.stream()
                .map(s-> {
                    CabWithDistance cabWithDistance1 = new CabWithDistance(s);
                    cabWithDistance1.setDistanceFromSource(calculateDistance(cabWithDistance1,cabWithDistance)); // mutate its state
                    return cabWithDistance1; // return mutated instance
                })
                .collect(Collectors.toList());
        if(null!=cabWithDistance.getColor() && !"".equals(cabWithDistance.getColor())){
            cabsWithDistance.sort( Comparator.comparing(CabWithDistance::getColor)
                    .thenComparing(CabWithDistance::getDistanceFromSource));

        }else {
            cabsWithDistance.sort(
                    Comparator.comparing(e -> e.getDistanceFromSource()));
        }
        return cabsWithDistance;
    }
    private Double calculateDistance(CabWithDistance bookingSource,CabWithDistance cabLocation){

     return   Math.sqrt(
                (cabLocation.getLongitude()-bookingSource.getLongitude())*(cabLocation.getLongitude()-bookingSource.getLongitude())
        +(cabLocation.getLatitude()-cabLocation.getLatitude())*(cabLocation.getLatitude()-bookingSource.getLatitude())
        );
    }


}
