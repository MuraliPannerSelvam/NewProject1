package com.onesoft.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onesoft.employee.exception.EmployeeNotFoundByAgeException;
import com.onesoft.employee.exception.EmployeeNotFoundByGenderException;
import com.onesoft.employee.exception.EmployeeNotFoundByIdException;
import com.onesoft.employee.exception.EmployeeNotFoundByNameException;
import com.onesoft.employee.exception.EmployeeNotFoundBySalaryException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empdao;

	public String addEmployee(Employee emp) {
		return empdao.addEmployee(emp);
	}

	// By using GetMapping

	public Employee getEmployee(int id) {
		return empdao.getEmployee(id);
	}
	
	public String updateEmployee(Employee id) {
		return empdao.updateEmployee(id);
	}
	
	// By using DeleteMapping

	public String addEmployee(int id) {
		return empdao.addEmployee(id);
	}
	
	// By using 
	
	public String listEmployee(List<Employee> emp) {
		return empdao.listEmployee(emp);
	}

	public List<Employee> listgetEmployee() {
		return empdao.listgetEmployee();
	}

// By using all methods or conditions	

	public List<Employee> getByGender(String gender) {
		List<Employee> allEmp=empdao.getAllEmp();
		List<Employee> results=allEmp.stream().filter(x-> x.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
		return results;
	}

	public List<Employee> getbySalary(int salary) {
		List<Employee> allEmp=empdao.getAllEmp();
		List<Employee> results=allEmp.stream().filter(x-> x.getSalary()>salary).collect(Collectors.toList());
		return results;
	}

	public List<String> getBySalaryName(int salary) {
		List<Employee> all=empdao.getAllEmp();
		List<String> results=all.stream().filter(x-> x.getSalary()>salary).map(z-> z.getName()).collect(Collectors.toList());
		return results;
	}

	public long getBySalaryCount(int salary) {
		List<Employee> all=empdao.getAllEmp();
		List<Employee> results=all.stream().filter(x-> x.getSalary()>salary).collect(Collectors.toList());
		long counts=results.stream().count();
		return counts;
	}

	public int getEmpMaxSalary() {
		List<Employee> all=empdao.getAllEmp();
		int max=0;
		for(Employee x : all) {
			if(x.getSalary()>max) {
				max=x.getSalary();
			}
			
		}
		return max;
	}

	public Employee getEmpMaxSalaryList() {
		List<Employee> all=empdao.getAllEmp();
		int max=all.get(0).getSalary();
		Employee emp=all.get(0);
		for(Employee x : all) {
			if(x.getSalary()>=max) {
				max=x.getSalary();
				emp=x;
			}
		}
		return emp;
	}



	public Employee getEmpMinAgeList() {
		List<Employee> all=empdao.getAllEmp();
		int min=all.get(0).getAge();
		Employee emp=all.get(0);
		for(Employee x : all) {
			if(x.getAge()<=min) {
				min=x.getAge();
				emp=x;
			}
		}
		return emp;
	}

	public List<Integer> getEmpAgelimit(int age1,int age2) {
		List<Employee> all=empdao.getAllEmp();
		List<Integer> results=all.stream().filter(x-> x.getAge()>age1&&x.getAge()<=age2).map(z->z.getId()).collect(Collectors.toList());
		return results;
	}
	
	public List<String> getEmpSalarylimit(int salary1,int salary2) {
		List<Employee> all=empdao.getAllEmp();
		List<String> results=all.stream().filter(x-> x.getSalary()>salary1&&x.getAge()<=salary2).map(z->z.getName()).collect(Collectors.toList());
		return results;
	}
	
	public List<Integer> getEmpNameId(String name) {
		List<Employee> all=empdao.getAllEmp();
		List<Integer> results=all.stream().filter(x-> x.getName().startsWith(name)).map(z->z.getId()).collect(Collectors.toList());
		return results;
	}

	public List<Employee> getEmpIncrement(int age) {
		List<Employee> all=empdao.getAllEmp();
		for(Employee x : all) {
			if(x.getAge()>age) {
				x.setSalary(x.getSalary()+(x.getSalary()*5/100));
			}
		}
		return all;
	}

	public List<Employee> getBySalary1(int sal1, int sal2) {
		return empdao.getBySalary1(sal1,sal2);
	}

// By using Exceptions for all
	
	public Employee getById(int id) throws EmployeeNotFoundByIdException {
		return empdao.getById(id);
	}
	
	public List<Employee> getByName(String name) throws EmployeeNotFoundByNameException {
		List<Employee> allEmp=empdao.getByName(name);
		if(allEmp.isEmpty()) {
			throw new EmployeeNotFoundByNameException();
		}
		else {
			return empdao.getByName(name);
		}
 	}

	public List<Employee> getByGender1(String gender) throws EmployeeNotFoundByGenderException {
		List<Employee> allEmp=empdao.getByGender1(gender);
		if(allEmp.isEmpty()) {
			throw new EmployeeNotFoundByGenderException();
		}
		else {
			return empdao.getByGender1(gender);
		}
	}
	
	public List<Employee> getByAge(int age) throws EmployeeNotFoundByAgeException {
		List<Employee> allEmp=empdao.getByAge(age);
		if(allEmp.isEmpty()) {
			throw new EmployeeNotFoundByAgeException();
		}
		else {
			return empdao.getByAge(age);
		}
	}
	
	public List<Employee> getBySalary1(int salary) throws EmployeeNotFoundBySalaryException {
		List<Employee> allEmp=empdao.getBySalary1(salary);
		if(allEmp.isEmpty()) {
			throw new EmployeeNotFoundBySalaryException();
		}
		else {
			return empdao.getBySalary1(salary);
		}
	}
	
	public String addByAgeLimits(Employee emps) throws EmployeeNotFoundByAgeException {
		if(emps.getAge()>18) {
			return empdao.addByAgeLimits(emps);
		}
		else {
			throw new EmployeeNotFoundByAgeException();
		}
	
	}

	
}