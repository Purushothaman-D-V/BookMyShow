package com.springboot.bookmyshow.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.bookmyshow.util.ResponseStructure;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;


@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler
{

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handleConstraintValidationException(ConstraintViolationException ex)
	{
		ResponseStructure<Object> responseStructure = new ResponseStructure<Object>();
		Map<String, String> hashMap = new HashMap<>();
		
		for(ConstraintViolation<?> violation : ex.getConstraintViolations())
		{
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hashMap.put(field, message);
		}
		
		responseStructure.setMessage("Add proper details");
		responseStructure.setStatus(HttpStatus.FORBIDDEN.value());
		responseStructure.setData(hashMap);
		return new ResponseEntity<Object>(responseStructure, HttpStatus.BAD_REQUEST);
	}
}
