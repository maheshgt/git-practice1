package com.example.practise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
	
	 @ExceptionHandler(Exception.class)
	    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	        ErrorResponse error = new ErrorResponse("Server Error");
	        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	    @ExceptionHandler(UserException.class)
	    public final ResponseEntity<Object> handleUserNotFoundException(UserException ex, WebRequest request) {
	        ErrorResponse error = new ErrorResponse("Record Not Found");
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }
}
