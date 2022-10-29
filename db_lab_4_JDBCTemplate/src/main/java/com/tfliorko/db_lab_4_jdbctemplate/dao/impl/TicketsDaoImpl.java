package com.tfliorko.db_lab_4_jdbctemplate.dao.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.TicketsDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketsDaoImpl implements TicketsDao {

    public static final String Find_All = "SELECT * FROM tickets";
    public static final String Find_By_Id = "SELECT * FROM tickets WHERE id = ?";
    public static final String Create = "INSERT INTO tickets (price, priority_pass, use_date, dysney_park_id, customer_id)VALUES (?, ?, ?, ?, ?)";
    public static final String Update = "UPDATE tickets SET price=?, priority_pass = ?, use_date=? WHERE id=?";
    public static final String Delete = "DELETE FROM tickets WHERE id=?";

    public static final String Find_By_Priority_Pass = "SELECT * FROM tickets WHERE priority_pass = ?";

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public TicketsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tickets> findAll(){
        return jdbcTemplate.query(Find_All, BeanPropertyRowMapper.newInstance(Tickets.class));
    };

    @Override
    public Optional<Tickets> findById(Integer id){
        Optional<Tickets> Tickets;
        try {
            Tickets = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Id, BeanPropertyRowMapper.newInstance(Tickets.class), id));
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            Tickets = Optional.empty();
        }
        return Tickets;
    };

    @Override
    public Integer create(Tickets tickets){
        return jdbcTemplate.update(Create, tickets.getId(), tickets.getPrice(), tickets.getPriority_pass(), tickets.getDysney_park_id(), tickets.getCustomer_id());
    }

    @Override
    public Integer update(Integer id, Tickets entity){
        return jdbcTemplate.update(Update, entity.getPrice(), entity.getPriority_pass(), entity.getUse_date(), id);
    }

    @Override
    public Integer delete(Integer id){
        return jdbcTemplate.update(Delete, id);
    }

    @Override
    public Optional<Tickets> findByPriority_pass(Boolean priority_pass){
        Optional<Tickets> Tickets;
        try {
            Tickets = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Priority_Pass, BeanPropertyRowMapper.newInstance(Tickets.class), priority_pass));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            Tickets = Optional.empty();
        }
        return Tickets;
    }
};

