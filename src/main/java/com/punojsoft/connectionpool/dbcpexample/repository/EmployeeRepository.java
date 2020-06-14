package com.punojsoft.connectionpool.dbcpexample.repository;

import com.punojsoft.connectionpool.dbcpexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
