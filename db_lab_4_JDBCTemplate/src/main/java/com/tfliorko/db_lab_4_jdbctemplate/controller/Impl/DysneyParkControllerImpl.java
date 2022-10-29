package com.tfliorko.db_lab_4_jdbctemplate.controller.Impl;

import com.tfliorko.db_lab_4_jdbctemplate.controller.DysneyParkController;
import com.tfliorko.db_lab_4_jdbctemplate.model.DysneyPark;
import com.tfliorko.db_lab_4_jdbctemplate.service.DysneyParkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DysneyParkControllerImpl  implements DysneyParkController {

    private final DysneyParkService dysneyParkService;

    public DysneyParkControllerImpl(DysneyParkService dysneyParkService) {
        this.dysneyParkService = dysneyParkService;
    }

    @Override
    public List<DysneyPark> findAll(){
        return dysneyParkService.findAll();
    }

    @Override
    public Optional<DysneyPark> findById(Integer id){
        return dysneyParkService.findById(id);
    }

    @Override
    public Integer create(DysneyPark dysneyPark){
        return dysneyParkService.create(dysneyPark);
    }

    @Override
    public Integer update(Integer id, DysneyPark entity){
        return dysneyParkService.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return dysneyParkService.delete(id);
    }

    @Override
    public Optional<DysneyPark> findByCity(String city){
        return dysneyParkService.findByCity(city);
    }

    @Override
    public Optional<DysneyPark> findByStreet(String street){
        return dysneyParkService.findByStreet(street);
    }
}
