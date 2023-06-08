package com.onesoft.employee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEmployeeController {
	
	EmployeeController ec=new EmployeeController();
	
	@Before
	public void display() {
		System.out.println("Hii");
	}
	
	@Test
	public void testlistgetEmployee() {
		System.out.println(ec.listgetEmployee());
	}
	
	@Test
	public void testgetEmployee() {
		System.out.println(ec.getEmployee(10));
	}
	
	@After
	public void show() {
		System.out.println("Thank You");
	}

}
