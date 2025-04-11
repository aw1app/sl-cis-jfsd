package com.sl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Exception handling for MyException anywhere it is thrown in this project
	@ExceptionHandler(MyException.class)
	public ResponseEntity<Object> handleMyException(MyException ex) {

		return new ResponseEntity<>(
				"<b>Some thing went wrong. </b>" + ex.getMessage() + ". Contact our CC <i>88888888888</i>",
				HttpStatus.BAD_REQUEST);

	}

	// Exception handling for ProductException anywhere it is thrown in this project
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Object> handleProductException(ProductException ex) {

		return new ResponseEntity<>(
				"<b>" + ex.getMessage() + "</b>. Contact our Technical Team at <i>88888888888</i>",
				HttpStatus.NOT_FOUND);
	}

	// Exception handling for above RuntimeException
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {

		return new ResponseEntity<>("<b>OOPs!!</b> something went wrong. Contact our CC <i>900123456</i>",
				HttpStatus.BAD_REQUEST);
	}

}
