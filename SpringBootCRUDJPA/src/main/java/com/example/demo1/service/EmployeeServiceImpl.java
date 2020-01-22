package com.example.demo1.service;

import com.example.demo1.dao.EmployeeRepository;
import com.example.demo1.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result= employeeRepository.findById(id);
        Employee theEmployee=null;
        if(result.isPresent())
        {
            theEmployee=result.get()  ;
        }                              else                                  {
            throw new RuntimeException("Did not find employee with ID-"+id);}
        return theEmployee;
    }

    @Override
    public void save(Employee employee) {
    employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
