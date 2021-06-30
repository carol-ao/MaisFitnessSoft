package com.basic.maisFitness.resources.exceptions;

import com.basic.maisFitness.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFoundException, HttpServletRequest httpServletRequest){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Resource not Found")
                .message(resourceNotFoundException.getMessage())
                .path(httpServletRequest.getRequestURI()).build());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodNotValid(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Invalid field input. Check field input requirements ( not empty and correct format).")
                .message(methodArgumentNotValidException.getMessage())
                .path(httpServletRequest.getRequestURI()).build());
    }

}
