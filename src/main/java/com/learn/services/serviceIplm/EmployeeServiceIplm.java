package com.learn.services.serviceIplm;

import com.learn.dao.EmployeeDao;
import com.learn.dao.daoIplm.EmployeeDaoIplm;
import com.learn.entities.Employee;
import com.learn.services.EmployeeService;

import java.util.List;

public class EmployeeServiceIplm implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceIplm() {
        employeeDao = new EmployeeDaoIplm();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public Employee getEmployeeId(Integer id) {
     return   employeeDao.getEmployeeId(id);
    }

    @Override
    public boolean addEmployee(Employee employee) {
       return employeeDao.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
       return  employeeDao.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        return employeeDao.deleteEmployee(id);
    }
}
