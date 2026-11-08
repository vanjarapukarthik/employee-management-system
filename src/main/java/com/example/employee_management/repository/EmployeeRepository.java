package com.example.employee_management.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.employee_management.Employee;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



public int saveEmployee(Employee employee) {

    String sql = "INSERT INTO employees (name, email, department, salary) VALUES (?, ?, ?, ?)";

    return jdbcTemplate.update(sql,
            employee.getName(),
            employee.getEmail(),
            employee.getDepartment(),
            employee.getSalary());
}
public List<Employee> getAllEmployees() {

    String sql = "SELECT * FROM employees";

    return jdbcTemplate.query(sql, (rs, rowNum) -> {

        Employee emp = new Employee();

        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setEmail(rs.getString("email"));
        emp.setDepartment(rs.getString("department"));
        emp.setSalary(rs.getDouble("salary"));

        return emp;
    });
}

public int updateEmployee(Employee employee) {

    String sql = "UPDATE employees SET name=?, email=?, department=?, salary=? WHERE id=?";

    return jdbcTemplate.update(sql,
            employee.getName(),
            employee.getEmail(),
            employee.getDepartment(),
            employee.getSalary(),
            employee.getId());
}
public int deleteEmployee(int id) {

    String sql = "DELETE FROM employees WHERE id=?";

    return jdbcTemplate.update(sql, id);
}

public Employee getEmployeeById(int id) {

    String sql = "SELECT * FROM employees WHERE id=?";

    return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
        Employee emp = new Employee();
        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setEmail(rs.getString("email"));
        emp.setDepartment(rs.getString("department"));
        emp.setSalary(rs.getDouble("salary"));
        return emp;
    }, id);
}
  public List<Employee> getEmployeesByDepartment(String department) {

    String sql = "SELECT * FROM employees WHERE department = ?";

    return jdbcTemplate.query(sql, (rs, rowNum) -> {
        Employee emp = new Employee();
        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setEmail(rs.getString("email"));
        emp.setDepartment(rs.getString("department"));
        emp.setSalary(rs.getDouble("salary"));
        return emp;
    }, department);
}
  public List<Employee> getEmployeesPaginated(int page, int size) {

	    String sql = "SELECT * FROM employees LIMIT ? OFFSET ?";

	    int offset = page * size;

	    return jdbcTemplate.query(sql, (rs, rowNum) -> {
	        Employee emp = new Employee();

	        emp.setId(rs.getInt("id"));
	        emp.setName(rs.getString("name"));
	        emp.setEmail(rs.getString("email"));
	        emp.setDepartment(rs.getString("department"));
	        emp.setSalary(rs.getDouble("salary"));

	        return emp;
	    }, size, offset);
	} }