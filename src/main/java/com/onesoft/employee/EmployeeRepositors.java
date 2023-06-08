package com.onesoft.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepositors extends JpaRepository<Employee, Integer> {
	@Query(value = "select*from employee where salary>=? and salary<=?", nativeQuery = true)
	public List<Employee> getBySalary1(int sal1, int sal2);

	@Query(value = "select*from employee where name=?", nativeQuery = true)
	public List<Employee> getByName(String name);

	@Query(value = "select*from employee where gender=?", nativeQuery = true)
	public List<Employee> getByGender1(String gender);

	@Query(value = "select*from employee where age=?", nativeQuery = true)
	public List<Employee> getByAge(int age);

	@Query(value = "select*from employee where salary=?", nativeQuery = true)
	public List<Employee> getBySalary1(int salary);

	

}
