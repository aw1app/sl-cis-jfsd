package com.sl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Exception handling for above MyException
	@ExceptionHandler(MyException.class)
	public ResponseEntity<Object> handleMyException(MyException ex) {
		System.out.println("INSIDE handleMyException of GlobalExceptionHandler class");

		return new ResponseEntity<>("<b>Some thing went wrong. </b>"+ ex.getMessage() +". Contact our CC <i>88888888888</i>",
				HttpStatus.BAD_REQUEST);

	}

	// Exception handling for above RuntimeException
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
		
		System.out.println("INSIDE handleRuntimeException of GlobalExceptionHandler class");

		return new ResponseEntity<>("<b>OOPs!!</b> something went wrong. Contact our CC <i>900123456</i>",
				HttpStatus.BAD_REQUEST);

	}

}
