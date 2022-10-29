package com.tfliorko.db_lab_4_jdbctemplate.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.tfliorko.db_lab_4_jdbctemplate.model.DysneyPark;
import com.tfliorko.db_lab_4_jdbctemplate.dao.DysneyParkDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DysneyParkDaoImpl implements DysneyParkDao {
    public static final String Find_All = "SELECT * FROM dysney_park";
    public static final String Find_By_Id = "SELECT * FROM dysney_park WHERE id = ?";
    public static final String Create = "INSERT INTO dysney_park(id, city, street, max_amount_of_visitors) VALUES (?, ?, ?, ?)";
    public static final String Update = "UPDATE dysney_park SET city=?, street=?, max_amount_of_visitors = ? WHERE id=?";
    public static final String Delete = "DELETE FROM dysney_park WHERE id=?";

    public static final String Find_By_City = "SELECT * FROM dysney_park WHERE city = ?";
    public static final String Find_By_Street = "SELECT * FROM dysney_park WHERE street = ?";

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public DysneyParkDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DysneyPark> findAll(){
        return jdbcTemplate.query(Find_All, BeanPropertyRowMapper.newInstance(DysneyPark.class));
    };

    @Override
    public Optional<DysneyPark> findById(Integer id){
        Optional<DysneyPark> DysneyParks;
        try {
            DysneyParks = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Id, BeanPropertyRowMapper.newInstance(DysneyPark.class), id));
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            DysneyParks = Optional.empty();
        }
        return DysneyParks;
    };

    @Override
    public Integer create(DysneyPark dysneyPark){
        return jdbcTemplate.update(Create, dysneyPark.getId(), dysneyPark.getCity(), dysneyPark.getStreet(), dysneyPark.getMax_amount_of_visitors());
    }

    @Override
    public Integer update(Integer id, DysneyPark entity){
        return jdbcTemplate.update(Update, entity.getCity(), entity.getStreet(),  entity.getMax_amount_of_visitors(), id);
    }

    @Override
    public Integer delete(Integer id){
        return jdbcTemplate.update(Delete, id);
    }

    @Override
    public Optional<DysneyPark> findByCity(String city){
        Optional<DysneyPark> dysneyParks;
        try {
            dysneyParks = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_City, BeanPropertyRowMapper.newInstance(DysneyPark.class), city));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            dysneyParks = Optional.empty();
        }
        return dysneyParks;
    }

    @Override
    public Optional<DysneyPark> findByStreet(String street){
        Optional<DysneyPark> dysneyParks;
        try {
            dysneyParks = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Street, BeanPropertyRowMapper.newInstance(DysneyPark.class), street));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            dysneyParks = Optional.empty();
        }
        return dysneyParks;
    }
};