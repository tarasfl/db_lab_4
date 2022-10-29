package com.tfliorko.db_lab_4_jdbctemplate.controller;

import com.tfliorko.db_lab_4_jdbctemplate.model.Tickets;

import java.util.Optional;

public interface TicketsController extends GeneralController <Tickets, Integer>{
    Optional<Tickets> findByPriority_pass(Boolean priority_pass);
}
