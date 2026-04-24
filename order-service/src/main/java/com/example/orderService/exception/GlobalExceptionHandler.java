package com.example.orderService.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	   @ExceptionHandler(OrderNotFoundException.class)
	    public ResponseEntity<ApiError> handleOrderNotFound(OrderNotFoundException ex) {

		   ApiError error = new ApiError(
	                HttpStatus.NOT_FOUND.value(),
	                ex.getMessage(),
	                LocalDateTime.now()
	        );

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	    }
	   
	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<ApiError> handleRuntimeException(RuntimeException ex) {

	    	ApiError error = new ApiError(
	                HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                ex.getMessage(),
	                LocalDateTime.now()
	        );

	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ApiError> handleGenericException(Exception ex) {

	        ApiError error = new ApiError(
	                HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                "Something went wrong",
	                LocalDateTime.now()
	        );

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	    }

}
