package com.example.employee_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_management.Employee;
import com.example.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public String saveEmployee(Employee employee) {
        if (employee.getName() == null || employee.getName().isBlank()) {
            return "Name is required";
        }
        if (employee.getSalary() < 0) {
            return "Salary cannot be negative";
        }
        repository.saveEmployee(employee);
        return "Employee saved successfully";
    }

    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return repository.getEmployeeById(id);
    }

    public String updateEmployee(int id, Employee employee) {
        employee.setId(id);
        repository.updateEmployee(employee);
        return "Employee updated successfully";
    }

    public String deleteEmployee(int id) {
        repository.deleteEmployee(id);
        return "Employee deleted successfully";
    }
    public List<Employee> getEmployeesByDepartment(String department) {
        return repository.getEmployeesByDepartment(department);
    }
    public List<Employee> getEmployeesPaginated(int page, int size) {
        return repository.getEmployeesPaginated(page, size);
    }}