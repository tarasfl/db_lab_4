package com.tfliorko.db_lab_4_jdbctemplate.service.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.DysneyParkDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.DysneyPark;
import com.tfliorko.db_lab_4_jdbctemplate.service.DysneyParkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DysneyParkServiceImpl implements DysneyParkService {
    private final DysneyParkDao dysneyParkDao;

    public DysneyParkServiceImpl(DysneyParkDao dysneyParkDao) {
        this.dysneyParkDao = dysneyParkDao;
    }

    @Override
    public List<DysneyPark> findAll(){
        return dysneyParkDao.findAll();
    }

    @Override
    public Optional<DysneyPark> findById(Integer id){
        return dysneyParkDao.findById(id);
    }

    @Override
    public Integer create(DysneyPark dysneyPark){
        return dysneyParkDao.create(dysneyPark);
    }

    @Override
    public Integer update(Integer id, DysneyPark entity){
        return dysneyParkDao.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return dysneyParkDao.delete(id);
    }

    @Override
    public Optional<DysneyPark> findByCity(String city){
        return dysneyParkDao.findByCity(city);
    }

    @Override
    public Optional<DysneyPark> findByStreet(String street){
        return dysneyParkDao.findByStreet(street);
    }
}
