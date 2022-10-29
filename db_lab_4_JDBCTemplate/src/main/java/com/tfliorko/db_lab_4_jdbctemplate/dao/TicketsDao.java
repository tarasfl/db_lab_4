package com.tfliorko.db_lab_4_jdbctemplate.dao;

import com.tfliorko.db_lab_4_jdbctemplate.model.Tickets;
import java.util.Optional;

public interface TicketsDao extends GeneralDao<Tickets, Integer>{
    Optional<Tickets> findByPriority_pass(Boolean priority_pass);
}
