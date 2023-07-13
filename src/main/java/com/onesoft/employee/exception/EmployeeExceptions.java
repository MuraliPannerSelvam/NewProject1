package com.onesoft.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptions {
	@ExceptionHandler(EmployeeNotFoundByIdException.class)
	public ResponseEntity<Object> idNotFound() {
		return new ResponseEntity<>("No Data Found By Id", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeNotFoundByNameException.class)
	public ResponseEntity<Object> nameNotFound() {
		return new ResponseEntity<>("No Data Found By Name", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeNotFoundByGenderException.class)
	public ResponseEntity<Object> genderNotFound() {
		return new ResponseEntity<>("No Data Found By Gender", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeNotFoundByAgeException.class)
	public ResponseEntity<Object> ageNotFound() {
		return new ResponseEntity<>("No Data Found By Age", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeNotFoundBySalaryException.class)
	public ResponseEntity<Object> salaryNotFound() {
		return new ResponseEntity<>("No Data Found By Salary", HttpStatus.NOT_FOUND);
	}

}
