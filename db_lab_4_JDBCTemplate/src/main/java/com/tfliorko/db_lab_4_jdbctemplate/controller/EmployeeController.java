package com.tfliorko.db_lab_4_jdbctemplate.controller;

import com.tfliorko.db_lab_4_jdbctemplate.model.Employee;

import java.util.Optional;

public interface EmployeeController extends GeneralController <Employee, Integer>{
    Optional<Employee> findByType_of_job(String type_of_job);
}
