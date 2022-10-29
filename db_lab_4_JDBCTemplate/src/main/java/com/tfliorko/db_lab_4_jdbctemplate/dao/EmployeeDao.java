package com.tfliorko.db_lab_4_jdbctemplate.dao;

import com.tfliorko.db_lab_4_jdbctemplate.model.Employee;

import java.util.Optional;

public interface EmployeeDao extends GeneralDao<Employee, Integer>{
    Optional<Employee> findByType_of_job(String type_of_job);
}
