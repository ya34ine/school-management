package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.entity.Employee;

public interface EmployeeRepsitory extends JpaRepository<Employee, Long>{


}
