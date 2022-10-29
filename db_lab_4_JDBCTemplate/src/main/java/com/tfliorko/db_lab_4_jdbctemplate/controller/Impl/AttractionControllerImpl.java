package com.tfliorko.db_lab_4_jdbctemplate.controller.Impl;

import com.tfliorko.db_lab_4_jdbctemplate.controller.AttractionController;
import com.tfliorko.db_lab_4_jdbctemplate.dao.AttractionDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.Attraction;
import com.tfliorko.db_lab_4_jdbctemplate.service.AttractionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionControllerImpl implements AttractionController {
    private final AttractionService attractionService;

    public AttractionControllerImpl(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @Override
    public List<Attraction> findAll(){
        return attractionService.findAll();
    }

    @Override
    public Optional<Attraction> findById(Integer id){
        return attractionService.findById(id);
    }

    @Override
    public Integer create(Attraction attraction){
        return attractionService.create(attraction);
    }

    @Override
    public Integer update(Integer id, Attraction entity){
        return attractionService.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return attractionService.delete(id);
    }

    @Override
    public Optional<Attraction> findByName(String name){
        return attractionService.findByName(name);
    }
}
