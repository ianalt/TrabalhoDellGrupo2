package com.residencia.dell.services;

import java.util.List;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.repositories.OrderlinesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderlinesService {
    
    @Autowired
    public OrderlinesRepository orderlinesRepository;

    // public Orderlines findById(Integer id){
    //     return orderlinesRepository.findById(id).get();
    // }

    // findOrderlineidAndOrderid
    public Orderlines findById(Integer orderlineId){
        return orderlinesRepository.findByOrderLinesId(orderlineId);
    }

    public List<Orderlines> findAll(){
        return orderlinesRepository.findAll();
    }

    public Long Count(){
        return orderlinesRepository.count();
    }

    public Orderlines save(Orderlines orderlines){
        return orderlinesRepository.save(orderlines);
    }

    public boolean delete(Integer id){
        if (id != null){
            orderlinesRepository.delete(orderlinesRepository.findByOrderLinesId(id));
            return true;
        }else{
            return false;
        }
    }

    public Orderlines update(Orderlines orderlines, Integer id){
        orderlines.setProdId(id); 
        return orderlinesRepository.save(orderlines);
    }


}
