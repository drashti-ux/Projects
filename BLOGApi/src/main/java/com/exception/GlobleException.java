package com.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.payload.ApiResponse;

@RestControllerAdvice
public class GlobleException {
	
	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoudExceptionHandler(ResourceNotFoundException e) {
		
		ApiResponse response = new ApiResponse(e.getMessage(),"false");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
 	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		Map<String, String> errs = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((err)->{
			String fielName = ((FieldError)err).getField();
			String message = err.getDefaultMessage();
			errs.put(fielName, message);
		});
		return new ResponseEntity<>(errs, HttpStatus.BAD_REQUEST);
	}

	
}
