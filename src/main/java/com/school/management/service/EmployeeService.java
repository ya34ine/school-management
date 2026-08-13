package com.school.management.service;

import com.school.management.entity.Employee;
import com.school.management.repository.EmployeeRepsitory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepsitory employeeRepository;

    public EmployeeService(EmployeeRepsitory employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployee(
            Long id,
            Employee employeeDetails) {

        return employeeRepository.findById(id)
                .map(employee -> {

                    employee.setFirstName(employeeDetails.getFirstName());
                    employee.setLastName(employeeDetails.getLastName());
                    employee.setEmail(employeeDetails.getEmail());
                    employee.setRole(employeeDetails.getRole());

                    return employeeRepository.save(employee);
                });
    }

    public boolean deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)) {
            return false;
        }

        employeeRepository.deleteById(id);
        return true;
    }
}