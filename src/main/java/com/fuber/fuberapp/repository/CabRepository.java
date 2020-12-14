package com.fuber.fuberapp.repository;


import com.fuber.fuberapp.pojo.Cab;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CabRepository {



    private static Map<Cab, Cab> cabDB= new HashMap<>();


    private Integer getId(){
        return cabDB.size()+1;
    }


    public Cab addCab(Cab cab) {
        cab.setId(getId());
        cabDB.put(cab,cab);
        return cab;
    }


    public Cab deleteCab(Integer id) {
        Cab cab =new Cab();
        cab.setId(id);
        Cab cabFromDb=cabDB.get(cab);
        return null!=cabFromDb?cabDB.remove(cab):null;

    }


    public Cab getCabDetail(Integer id) {
        Cab cab =new Cab();
        cab.setId(id);
        Cab cabFromDb=cabDB.get(cab);
        return cabFromDb;
    }

    public List<Cab> getCabs() {
        List<Cab> cabList=new ArrayList<>();
        for(Map.Entry<Cab,Cab> entry:cabDB.entrySet()){
            cabList.add(entry.getValue());
        }
        return cabList;
    }

    public Cab updateCabDetail(Cab cab, Integer cabId) {
        cab.setId(cabId);
        Cab cabFromDb=cabDB.get(cab);
        return null!=cabFromDb?cabDB.put(cab,cab):null;
    }
}
