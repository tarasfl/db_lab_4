package com.tfliorko.db_lab_4_jdbctemplate.dao.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.ShowDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowDaoImpl implements ShowDao {

    public static final String Find_All = "SELECT * FROM `show`";
    public static final String Find_By_Id = "SELECT * FROM `show` WHERE id = ?";
    public static final String Create = "INSERT INTO `show`(id, name, date, max_amount_of_visitors, dysney_park_id) VALUES (?, ?, ?, ?, ?)";
    public static final String Update = "UPDATE `show` SET name=?, date=?,  max_amount_of_visitors = ? WHERE id=?";
    public static final String Delete = "DELETE FROM `show` WHERE id=?";

    public static final String Find_By_Name = "SELECT * FROM `show` WHERE name = ?";

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public ShowDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Show> findAll(){
        return jdbcTemplate.query(Find_All, BeanPropertyRowMapper.newInstance(Show.class));
    };

    @Override
    public Optional<Show> findById(Integer id){
        Optional<Show> Shows;
        try {
            Shows = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Id, BeanPropertyRowMapper.newInstance(Show.class), id));
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            Shows = Optional.empty();
        }
        return Shows;
    };

    @Override
    public Integer create(Show show){
        return jdbcTemplate.update(Create, show.getId(), show.getName(), show.getDate(), show.getMax_amount_of_visitors(), show.getDysney_park_id());
    }

    @Override
    public Integer update(Integer id, Show entity){
        return jdbcTemplate.update(Update, entity.getName(), entity.getDate(), entity.getMax_amount_of_visitors(), id);
    }

    @Override
    public Integer delete(Integer id){
        return jdbcTemplate.update(Delete, id);
    }

    @Override
    public Optional<Show> findByName(String name){
        Optional<Show> shows;
        try {
            shows = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Name, BeanPropertyRowMapper.newInstance(Show.class), name));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            shows = Optional.empty();
        }
        return shows;
    }
};

