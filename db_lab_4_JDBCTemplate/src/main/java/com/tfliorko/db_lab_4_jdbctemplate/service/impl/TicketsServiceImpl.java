package com.tfliorko.db_lab_4_jdbctemplate.service.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.TicketsDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.Tickets;
import com.tfliorko.db_lab_4_jdbctemplate.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketsServiceImpl implements TicketsService {
    @Autowired
    private final TicketsDao ticketsDao;

    public TicketsServiceImpl(TicketsDao ticketsDao) {
        this.ticketsDao = ticketsDao;
    }

    @Override
    public List<Tickets> findAll(){
        return ticketsDao.findAll();
    }

    @Override
    public Optional<Tickets> findById(Integer id){
        return ticketsDao.findById(id);
    }

    @Override
    public Integer create(Tickets tickets){
        return ticketsDao.create(tickets);
    }

    @Override
    public Integer update(Integer id, Tickets entity){
        return ticketsDao.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return ticketsDao.delete(id);
    }

    @Override
    public Optional<Tickets> findByPriority_pass(Boolean priority_pass){
        return ticketsDao.findByPriority_pass(priority_pass);
    }
}
