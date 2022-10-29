package com.tfliorko.db_lab_4_jdbctemplate.dao.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.CustomerDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.tfliorko.db_lab_4_jdbctemplate.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDaoImpl implements CustomerDao {

    public static final String Find_All = "SELECT * FROM customer";
    public static final String Find_By_Id = "SELECT * FROM cutomer WHERE id = ?";
    public static final String Create = "INSERT INTO customer(id, first_name, second_name, birthday) VALUES (?, ?, ?, ?)";
    public static final String Update = "UPDATE customer SET first_name=?, second_name = ?, birthday = ? WHERE id=?";
    public static final String Delete = "DELETE FROM customer WHERE id=?";

    public static final String Find_By_First_Name = "SELECT * FROM customer WHERE first_name = ?";
    public static final String Find_By_Second_Name = "SELECT * FROM customer WHERE second_name = ?";

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> findAll(){
        return jdbcTemplate.query(Find_All, BeanPropertyRowMapper.newInstance(Customer.class));
    };

    @Override
    public Optional<Customer> findById(Integer id){
        Optional<Customer> Customers;
        try {
            Customers = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Id, BeanPropertyRowMapper.newInstance(Customer.class), id));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            Customers = Optional.empty();
        }
        return Customers;
    };

    @Override
    public Integer create(Customer customer){
        return jdbcTemplate.update(Create, customer.getId(), customer.getFirst_name(), customer.getSecond_name(), customer.getBirthday());
    }

    @Override
    public Integer update(Integer id, Customer entity){
        return jdbcTemplate.update(Update, entity.getFirst_name(), entity.getSecond_name(), entity.getBirthday(), id);
    }

    @Override
    public Integer delete(Integer id){
        return jdbcTemplate.update(Delete, id);
    }

    @Override
    public Optional<Customer> findByFirst_name(String first_name){
        Optional<Customer> Customers;
        try {
            Customers = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_First_Name, BeanPropertyRowMapper.newInstance(Customer.class), first_name));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            Customers = Optional.empty();
        }
        return Customers;
    }

    @Override
    public Optional<Customer> findBySecond_name(String second_name){
        Optional<Customer> Customers;
        try {
            Customers = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Second_Name, BeanPropertyRowMapper.newInstance(Customer.class), second_name));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            Customers = Optional.empty();
        }
        return Customers;
    }
};
