package com.tfliorko.db_lab_4_jdbctemplate.dao.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.EmployeeDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

    public static final String Find_All = "SELECT * FROM employee";
    public static final String Find_By_Id = "SELECT * FROM employee WHERE id = ?";
    public static final String Create = "INSERT INTO employee(id, first_name, second_name, type_of_job, attraction_id) VALUES (?, ?, ?, ?, ?)";
    public static final String Update = "UPDATE employee SET first_name=?, second_name = ?, type_of_job=? WHERE id=?";
    public static final String Delete = "DELETE FROM employee WHERE id=?";

    public static final String Find_By_Type_of_Job = "SELECT * FROM employee WHERE type_of_job = ?";

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll(){
        return jdbcTemplate.query(Find_All, BeanPropertyRowMapper.newInstance(Employee.class));
    };

    @Override
    public Optional<Employee> findById(Integer id){
        Optional<Employee> Employees;
        try {
            Employees = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Id, BeanPropertyRowMapper.newInstance(Employee.class), id));
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            Employees = Optional.empty();
        }
        return Employees;
    };

    @Override
    public Integer create(Employee employee){
        return jdbcTemplate.update(Create, employee.getId(), employee.getFirst_name(), employee.getSecond_name(), employee.getType_of_job(), employee.getAttraction_id());
    }

    @Override
    public Integer update(Integer id, Employee entity){
        return jdbcTemplate.update(Update, entity.getFirst_name(), entity.getSecond_name(), entity.getType_of_job(), id);
    }

    @Override
    public Integer delete(Integer id){
        return jdbcTemplate.update(Delete, id);
    }

    @Override
    public Optional<Employee> findByType_of_job(String type_of_job){
        Optional<Employee> Employees;
        try {
            Employees = Optional.ofNullable(jdbcTemplate.queryForObject(Find_By_Type_of_Job, BeanPropertyRowMapper.newInstance(Employee.class), type_of_job));
        } catch (EmptyResultDataAccessException  e) {
            System.out.println(e);
            Employees = Optional.empty();
        }
        return Employees;
    }
};
