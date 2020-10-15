package com.wellsfargo.fsd.imsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.wellsfargo.fsd.imsa.exception.InvException;


@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(InvException.class)
	public ResponseEntity<String> handleImsException(InvException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}



