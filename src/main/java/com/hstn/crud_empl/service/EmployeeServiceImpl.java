package com.hstn.crud_empl.service;

import com.hstn.crud_empl.dao.EmployeeDAO;
import com.hstn.crud_empl.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
        // Это мы добавили самостоятельно вместо того что было
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Override
    @Transactional
    // Эта аннотация здесь нужна потому что происходит изменение данных
    public Employee save(Employee employees) {
        return employeeDAO.save(employees);
    }

    @Override
    @Transactional
    // Эта аннотация здесь нужна потому что происходит изменение данных
    public void deleteEmployeeById(int id) {
        employeeDAO.deleteEmployeeById(id);
    }
}

