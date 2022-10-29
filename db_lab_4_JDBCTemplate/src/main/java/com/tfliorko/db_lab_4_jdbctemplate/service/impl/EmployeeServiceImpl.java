package com.tfliorko.db_lab_4_jdbctemplate.service.impl;

import com.tfliorko.db_lab_4_jdbctemplate.dao.EmployeeDao;
import com.tfliorko.db_lab_4_jdbctemplate.model.Employee;
import com.tfliorko.db_lab_4_jdbctemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl( EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id){
        return employeeDao.findById(id);
    }

    @Override
    public Integer create(Employee employee){
        return employeeDao.create(employee);
    }

    @Override
    public Integer update(Integer id, Employee entity){
        return employeeDao.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return employeeDao.delete(id);
    }

    @Override
    public Optional<Employee> findByType_of_job(String type_of_job){
        return employeeDao.findByType_of_job(type_of_job);
    }
}
