package com.tfliorko.db_lab_4_jdbctemplate.controller.Impl;

import com.tfliorko.db_lab_4_jdbctemplate.controller.EmployeeController;
import com.tfliorko.db_lab_4_jdbctemplate.model.Employee;
import com.tfliorko.db_lab_4_jdbctemplate.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeControllerImpl  implements EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeControllerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id){
        return employeeService.findById(id);
    }

    @Override
    public Integer create(Employee employee){
        return employeeService.create(employee);
    }

    @Override
    public Integer update(Integer id, Employee entity){
        return employeeService.update(id, entity);
    }

    @Override
    public Integer delete(Integer id){
        return employeeService.delete(id);
    }

    @Override
    public Optional<Employee> findByType_of_job(String type_of_job){
        return employeeService.findByType_of_job(type_of_job);
    }
}
