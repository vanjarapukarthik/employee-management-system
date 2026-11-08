package com.example.employee_management.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.employee_management.Employee;
import com.example.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public String saveEmployee(@RequestBody @Valid Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return service.getEmployeesByDepartment(department);
    
    } 
    
    @GetMapping("/page")
    public List<Employee> getEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getEmployeesPaginated(page, size);
    }}