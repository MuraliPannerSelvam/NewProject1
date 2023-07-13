package com.onesoft.employee;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.employee.exception.EmployeeNotFoundByAgeException;
import com.onesoft.employee.exception.EmployeeNotFoundByGenderException;
import com.onesoft.employee.exception.EmployeeNotFoundByIdException;
import com.onesoft.employee.exception.EmployeeNotFoundByNameException;
import com.onesoft.employee.exception.EmployeeNotFoundBySalaryException;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empser;

	static Logger log = Logger.getLogger(EmployeeController.class);

	@PostMapping(value = "/add")
	public String addEmployee(@RequestBody Employee emp) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(emp);
		return empser.addEmployee(emp);
	}

// By using GetMapping

	@GetMapping(value = "/get/{id}")
	public Employee getEmployee(@PathVariable int id) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(id);
		return empser.getEmployee(id);
	}

	@PutMapping(value = "/update/{id}")
	public String updateEmployee(@RequestBody Employee id) {
		return empser.updateEmployee(id);
	}

// By using DeleteMapping

	@DeleteMapping(value = "/delete/{id}")
	public String addEmployee(@PathVariable int id) {
		return empser.addEmployee(id);
	}

// by using List of Employee

	@PostMapping(value = "/list")
	public String listEmployee(@RequestBody List<Employee> emp) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(emp);
		return empser.listEmployee(emp);
	}

// By using List of all Employee

	@GetMapping(value = "/listget")
	public List<Employee> listgetEmployee() {
		PropertyConfigurator.configure("log4j.properties");
		log.info(empser.listgetEmployee());
		return empser.listgetEmployee();
	}

	@GetMapping(value = "/getEmpGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return empser.getByGender(gender);
	}

	@GetMapping(value = "/getEmpSalary/{salary}")
	public List<Employee> getBySalary(@PathVariable int salary) {
		return empser.getbySalary(salary);
	}

	@GetMapping(value = "/getEmpSalaryName/{salary}")
	public List<String> getBySalaryName(@PathVariable int salary) {
		return empser.getBySalaryName(salary);
	}

	@GetMapping(value = "/getEmpSalaryCount/{salary}")
	public long getBySalaryCount(@PathVariable int salary) {
		return empser.getBySalaryCount(salary);
	}

	@GetMapping(value = "/getEmpMaxSalary")
	public int getEmpMaxSalary() {
		return empser.getEmpMaxSalary();
	}

	@GetMapping(value = "/getEmpMaxSalaryList")
	public Employee getEmpMaxSalaryList() {
		return empser.getEmpMaxSalaryList();
	}

	@GetMapping(value = "/getEmpMinAgeList")
	public Employee getEmpMinAgeList() {
		return empser.getEmpMinAgeList();
	}

	@GetMapping(value = "/getEmpAgeLimit/{age1}/{age2}")
	public List<Integer> getEmpAgeLimit(@PathVariable int age1, @PathVariable int age2) {
		return empser.getEmpAgelimit(age1, age2);
	}

	@GetMapping(value = "/getEmpSalaryLimit/{salary1}/{salary2}")
	public List<String> getEmpSalaryLimit(@PathVariable int salary1, @PathVariable int salary2) {
		return empser.getEmpSalarylimit(salary1, salary2);
	}

	@GetMapping(value = "/getEmpNameLimit/{name}")
	public List<Integer> getEmpNameId(@PathVariable String name) {
		return empser.getEmpNameId(name);
	}

	@GetMapping(value = "/getEmpIncrement/{age}")
	public List<Employee> getEmpIncrement(@PathVariable int age) {
		return empser.getEmpIncrement(age);
	}

	@GetMapping(value = "/getBySalary1/{sal1}/{sal2}")
	public List<Employee> getBySalary1(@PathVariable int sal1, @PathVariable int sal2) {
		return empser.getBySalary1(sal1, sal2);
	}

// By using exception for all variables	

	@GetMapping(value = "/ExceptionId/{id}")
	public Employee getById(@PathVariable int id) throws EmployeeNotFoundByIdException {
		return empser.getById(id);
	}

	@GetMapping(value = "/ExceptionName/{name}")
	public List<Employee> getByName(@PathVariable String name) throws EmployeeNotFoundByNameException {
		return empser.getByName(name);
	}

	@GetMapping(value = "/ExceptionGender/{gender}")
	public List<Employee> getByGender1(@PathVariable String gender) throws EmployeeNotFoundByGenderException {
		return empser.getByGender1(gender);
	}

	@GetMapping(value = "/ExceptionAge/{age}")
	public List<Employee> getByAge(@PathVariable int age) throws EmployeeNotFoundByAgeException {
		return empser.getByAge(age);
	}

	@GetMapping(value = "/ExceptionSalary/{salary}")
	public List<Employee> getBySalary1(@PathVariable int salary) throws EmployeeNotFoundBySalaryException {
		return empser.getBySalary1(salary);
	}

	@PostMapping(value = "/addByAgeLimits")
	public String addByAgeLimits(@RequestBody Employee emps) throws EmployeeNotFoundByAgeException {
		return empser.addByAgeLimits(emps);
	}

}