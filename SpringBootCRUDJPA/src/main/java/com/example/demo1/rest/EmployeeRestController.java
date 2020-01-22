package com.example.demo1.rest;

import com.example.demo1.entity.Employee;
import com.example.demo1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService) {
        employeeService = theemployeeService;
    }

@GetMapping("/employees")
    private List<Employee> findAll()
{
    return employeeService.findAll();
}
@GetMapping("/employees/{employeeid}")
private Employee getEmployeeByid(@PathVariable int employeeid){

    Employee employee=employeeService.findById(employeeid);
    if(employee==null)
    {
        throw new RuntimeException("Not found");
    }
    return  employee;
}
@PostMapping("/employees")
public Employee addEmployee(@RequestBody Employee employee)
{
    employee.setId(0);
        employeeService.save(employee);
    return employee;
}

@PutMapping("/employees")
public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeId(@PathVariable int employeeId)
    {
        Employee employee=employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("Not found");
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee-"+employeeId;
    }
}
