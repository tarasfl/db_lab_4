package com.tfliorko.db_lab_4_jdbctemplate.controller.Impl;

import com.tfliorko.db_lab_4_jdbctemplate.controller.TicketsController;
import com.tfliorko.db_lab_4_jdbctemplate.model.Tickets;
import com.tfliorko.db_lab_4_jdbctemplate.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TicketsControllerImpl implements TicketsController {
    @Autowired
    private final TicketsService ticketsService;

    public TicketsControllerImpl(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }


    @Override
    public List<Tickets> findAll(){
        return ticketsService.findAll();
    }

    @Override
    public Optional<Tickets> findById(Integer id){
        return ticketsService.findById(id);
    }

    @Override
    public Integer create(Tickets tickets){
        return ticketsService.create(tickets);
    }

    @Override
    public Integer update(Integer id, Tickets entity){
        return ticketsService.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return ticketsService.delete(id);
    }

    @Override
    public Optional<Tickets> findByPriority_pass(Boolean priority_pass){
        return ticketsService.findByPriority_pass(priority_pass);

    }
}
