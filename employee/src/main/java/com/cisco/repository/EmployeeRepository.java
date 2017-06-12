package com.cisco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cisco.pojo.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, String> {

	
}
