package com.tfliorko.db_lab_4_jdbctemplate.controller.Impl;

import com.tfliorko.db_lab_4_jdbctemplate.controller.ShowController;
import com.tfliorko.db_lab_4_jdbctemplate.model.Show;
import com.tfliorko.db_lab_4_jdbctemplate.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ShowControllerImpl implements ShowController {
    private final ShowService showService;

    public ShowControllerImpl(ShowService showService) {
        this.showService = showService;
    }


    @Override
    public List<Show> findAll(){
        return showService.findAll();
    }

    @Override
    public Optional<Show> findById(Integer id){
        return showService.findById(id);
    }

    @Override
    public Integer create(Show show){
        return showService.create(show);
    }

    @Override
    public Integer update(Integer id, Show entity){
        return showService.update(id, entity);
    }

    @Override
    public Integer delete(Integer id) {
        return showService.delete(id);
    }
    @Override
    public Optional<Show> findByName(String name){
        return showService.findByName(name);
    }
}
