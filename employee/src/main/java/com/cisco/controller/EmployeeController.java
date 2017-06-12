package com.cisco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.pojo.Employee;
import com.cisco.service.EmployeeService;

import io.swagger.annotations.Api;

@Api(basePath = "/", value = "/", description = "Home Controller")
@RestController
@RequestMapping("/product")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value="/list")
	public List<Employee> getEmployeeList(){
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value="/list/{id}")
	public Employee getEmployee(@PathVariable("id") String id){
		//return employeeService.getEmployee(id);
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(value="/list/add", method=org.springframework.web.bind.annotation.RequestMethod.POST)
	public void addEmployee(@RequestBody Employee emp){
		 //employeeService.addEmployee(emp);
		 employeeService.saveEmployee(emp);
	}
	
	@RequestMapping(value="/list/{id}", method=org.springframework.web.bind.annotation.RequestMethod.PUT)
	public void updateEmployee(@PathVariable("id") String id, @RequestBody Employee emp){
		// employeeService.updateEmployee(emp,id);
		 employeeService.setEmployee(emp,id);
	}
	
	@RequestMapping(value="/list/{id}", method=org.springframework.web.bind.annotation.RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") String id){
		 employeeService.removeEmployee(id);
	}
}
