package com.example.humanresource.employee;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        // employee.setMid(UUID.randomUUID().toString().replaceAll("-", ""));
        // employee.setCreateTime(new Date());
        // employeeRepository.save(employee);
        // return employee;
        return null;
    }

}