package com.tfliorko.db_lab_4_jdbctemplate.service.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.ShowDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.Show;
import com.tfliorko.db_lab_4_jdbctemplate.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowDao showDao;


    public ShowServiceImpl(ShowDao showDao) {
        this.showDao = showDao;
    }

    @Override
    public List<Show> findAll(){
        return showDao.findAll();
    }

    @Override
    public Optional<Show> findById(Integer id){
        return showDao.findById(id);
    }

    @Override
    public Integer create(Show show){
        return showDao.create(show);
    }

    @Override
    public Integer update(Integer id, Show entity){
        return showDao.update(id, entity);
    }

    @Override
    public Integer delete(Integer id) {
        return showDao.delete(id);
    }
    @Override
    public Optional<Show> findByName(String name){
        return showDao.findByName(name);
    }
}
