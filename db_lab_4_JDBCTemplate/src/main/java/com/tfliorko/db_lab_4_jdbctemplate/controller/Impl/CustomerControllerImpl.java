package com.tfliorko.db_lab_4_jdbctemplate.controller.Impl;

import com.tfliorko.db_lab_4_jdbctemplate.controller.CustomerController;
import com.tfliorko.db_lab_4_jdbctemplate.model.Customer;
import com.tfliorko.db_lab_4_jdbctemplate.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerControllerImpl implements CustomerController {
    private final CustomerService customerService;

    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id){
        return customerService.findById(id);
    }

    @Override
    public Integer create(Customer customer){
        return customerService.create(customer);
    }

    @Override
    public Integer update(Integer id, Customer entity){
        return customerService.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return customerService.delete(id);
    }

    @Override
    public Optional<Customer> findByFirst_name(String first_name){
        return customerService.findByFirst_name(first_name);
    }

    @Override
    public Optional<Customer> findBySecond_name(String second_name){
        return customerService.findBySecond_name(second_name);
    }
}
