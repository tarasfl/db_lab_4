package com.tfliorko.db_lab_4_jdbctemplate.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import com.tfliorko.db_lab_4_jdbctemplate.dao.AttractionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.tfliorko.db_lab_4_jdbctemplate.model.Attraction;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionDaoImpl implements AttractionDao {

    public static final String Find_All = "SELECT * FROM attraction";
    public static final String Find_By_Id = "SELECT * FROM attraction WHERE id = ?";
    public static final String Create = "INSERT INTO attraction(id, name, priority_pass, max_amount_of_visitors, dysney_park_id) VALUES (?, ?, ?, ?)";
    public static final String Update = "UPDATE attraction SET name=?, priority_pass=?,max_amount_of_visitors = ? WHERE id=?";
    public static final String Delete = "DELETE FROM attraction WHERE id=?";

    public static final String Find_By_Name = "SELECT * FROM attraction WHERE name = ?";

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public AttractionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Attraction> findAll(){
      return jdbcTemplate.query(Find_All, BeanPropertyRowMapper.newInstance(Attraction.class));
    };

    @Override
    public Optional<Attraction> findById(Integer id){
        Optional<Attraction> Attractions;
        try {
            Attractions = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Id, BeanPropertyRowMapper.newInstance(Attraction.class), id));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            Attractions = Optional.empty();
        }
        return Attractions;
    };

    @Override
    public Integer create(Attraction attraction){
        return jdbcTemplate.update(Create, attraction.getId(), attraction.getName(), attraction.getMax_amount_of_visitors(), attraction.getDysney_park_id());
    }

    @Override
    public Integer update(Integer id, Attraction entity){
        return jdbcTemplate.update(Update, entity.getName(), entity.getPriority_pass(), entity.getMax_amount_of_visitors(), id);
    }

    @Override
    public Integer delete(Integer id){
        return jdbcTemplate.update(Delete, id);
    }

    @Override
    public Optional<Attraction> findByName(String name){
        Optional<Attraction> Attractions;
        try {
            Attractions = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Name, BeanPropertyRowMapper.newInstance(Attraction.class), name));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            Attractions = Optional.empty();
        }
        return Attractions;
    }
};
