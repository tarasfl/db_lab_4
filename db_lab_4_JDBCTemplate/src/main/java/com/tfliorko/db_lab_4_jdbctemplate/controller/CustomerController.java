package com.tfliorko.db_lab_4_jdbctemplate.controller;

import com.tfliorko.db_lab_4_jdbctemplate.model.Customer;

import java.util.Optional;

public interface CustomerController extends GeneralController <Customer, Integer>{
    Optional<Customer> findByFirst_name(String first_name);

    Optional<Customer> findBySecond_name(String second_name);
}
