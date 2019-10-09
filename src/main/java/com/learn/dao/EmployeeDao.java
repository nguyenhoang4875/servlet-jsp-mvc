package com.learn.dao;

import com.learn.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeId(Integer id);
    public boolean addEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployee(Integer id);

}
