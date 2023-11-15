package com.mourid.services;

import com.mourid.dao.IDao;
import com.mourid.entities.Employee;
import com.mourid.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IDao<Employee> {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee o) {
        return employeeRepository.save(o);
    }

    @Override
    public Employee update(Employee o) {
        return employeeRepository.save(o);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean delete(Employee o) {
        try{
            employeeRepository.delete(o);
            return true;

        }catch (Exception e){
            return false;
        }
    }
}
