package com.cisco.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.pojo.Employee;
import com.cisco.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private List<Employee> list= new ArrayList<>(Arrays.asList(new Employee("1", "Ram", 100),new Employee("2", "Shaam", 200),new Employee("3", "Lakhan", 300)));
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getAllEmployees(){
		List<Employee> list= new ArrayList<Employee>();
		repository.findAll().
		forEach(list::add);
		return list;
	} 
	
	public Employee getEmployeeById(String id){
		return repository.findOne(id);
	} 
	
	public void saveEmployee(Employee emp){
		repository.save(emp);
	}
	
	
	public void setEmployee(Employee emp,String id){
		repository.save(emp);
	}
	
	public void removeEmployee(String id){
		repository.delete(id);
	}
	
	
	
	
	
	
	
	
	public List<Employee> getEmployees(){
		return list;
	}
	
	public Employee getEmployee(String id){
		Optional opr = list.stream().filter(f -> f.getId().equals(id)).findFirst();
		return (Employee) opr.get();
	}
	
	public void updateEmployee(Employee emp,String id){
		int index=0;
		for (Employee employee : list) {
			if(employee.getId().equals(id)){
				list.set(index, emp);
			}
			index++;
		}
	}
	
	public void addEmployee(Employee emp){
		list.add(emp);
	}
	
	public void deleteEmployee(String id){
		
		Employee emp=list.stream().filter(f -> f.getId().equals(id)).findFirst().get();
		list.remove(emp);
	}
	
}
