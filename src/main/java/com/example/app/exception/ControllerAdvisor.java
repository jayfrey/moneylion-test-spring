package com.example.app.exception;

import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
    									MethodArgumentNotValidException e, 
    									HttpHeaders headers, 
    									HttpStatus status, 
    									WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", "Invalid Parameter");
        
        Map<String, Object> message = new LinkedHashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
        	message.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        body.put("message", message);
        body.put("path", ((ServletWebRequest)request).getRequest().getRequestURI().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
	
	@Override
	public ResponseEntity<Object> handleHttpMessageNotReadable(
								HttpMessageNotReadableException e, 
								HttpHeaders headers, 
								HttpStatus status,
								WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", "Bad Request");
        body.put("message", "Invalid Request Body");
        body.put("path", ((ServletWebRequest)request).getRequest().getRequestURI().toString());
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
}
