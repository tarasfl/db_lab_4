package com.tfliorko.db_lab_4_jdbctemplate.service;

import com.tfliorko.db_lab_4_jdbctemplate.model.Tickets;

import java.util.Optional;

public interface TicketsService extends GeneralService<Tickets, Integer>{
    Optional<Tickets> findByPriority_pass(Boolean priority_pass);
}
