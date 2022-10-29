package com.tfliorko.db_lab_4_jdbctemplate.service.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.AttractionDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.Attraction;
import com.tfliorko.db_lab_4_jdbctemplate.service.AttractionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionServiceImpl implements AttractionService {

    private final AttractionDao attractionDao;

    public AttractionServiceImpl(AttractionDao attractionDao) {
        this.attractionDao = attractionDao;
    }

    @Override
    public List<Attraction> findAll(){
        return attractionDao.findAll();
    }

    @Override
    public Optional<Attraction> findById(Integer id){
        return attractionDao.findById(id);
    }

    @Override
    public Integer create(Attraction attraction){
        return attractionDao.create(attraction);
    }

    @Override
    public Integer update(Integer id, Attraction entity){
        return attractionDao.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return attractionDao.delete(id);
    }

    @Override
    public Optional<Attraction> findByName(String name){
        return attractionDao.findByName(name);
    }


}
