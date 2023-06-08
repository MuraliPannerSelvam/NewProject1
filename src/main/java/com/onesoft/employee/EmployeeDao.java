package com.onesoft.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.employee.exception.EmployeeNotFoundByIdException;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepositors empRepo;
	public String addEmployee(Employee emp) {
		empRepo.save(emp);
		return "Successfully Saved";
	}
	
	// By using GetMapping
	
	public Employee getEmployee(int id) {
		return empRepo.findById(id).get();
	}
	
	public String updateEmployee(Employee id) {
		empRepo.save(id);
		return "Successfully Updated";
	}
	
	// By using DeleteMapping
	
	public String addEmployee(int id) {
		empRepo.deleteById(id);
		return "Successfully Deleted";
	}
	
	// By using List of Employee

	public String listEmployee(List<Employee> emp) {
		empRepo.saveAll(emp);
		return "Successfully Saved";
	}
	
	// By using List of all Employee 

	public List<Employee> listgetEmployee() {
		return empRepo.findAll();
	}
	
	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}

	public List<Employee> getBySalary1(int sal1, int sal2) {
		return empRepo.getBySalary1(sal1, sal2);
	}
	
	public Employee getById(int id) throws EmployeeNotFoundByIdException {
		return empRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundByIdException());
		
	}
	
	public List<Employee> getByName(String name) {
		return empRepo.getByName(name);
	}
	
	public List<Employee> getByGender1(String gender) {
		return empRepo.getByGender1(gender);
	}
	
	public List<Employee> getByAge(int age) {
		return empRepo.getByAge(age);
	}
	
	public List<Employee> getBySalary1(int salary) {
		return empRepo.getBySalary1(salary);
	}
	
	public String addByAgeLimits(Employee emps) {
		empRepo.save(emps);
		return "Successfully Saved";
	}

}
