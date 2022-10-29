package com.tfliorko.db_lab_4_jdbctemplate.service.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.CustomerDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.Customer;
import com.tfliorko.db_lab_4_jdbctemplate.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> findAll(){
        return customerDao.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id){
        return customerDao.findById(id);
    }

    @Override
    public Integer create(Customer customer){
        return customerDao.create(customer);
    }

    @Override
    public Integer update(Integer id, Customer entity){
        return customerDao.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return customerDao.delete(id);
    }

    @Override
    public Optional<Customer> findByFirst_name(String first_name){
        return customerDao.findByFirst_name(first_name);
    }

    @Override
    public Optional<Customer> findBySecond_name(String second_name){
        return customerDao.findBySecond_name(second_name);
    }

}
