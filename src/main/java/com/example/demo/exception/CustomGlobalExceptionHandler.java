package com.example.demo.exception;

import com.example.demo.response.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity resourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, new Response(null, e.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity businessException(BusinessException e, WebRequest request) {
        return handleExceptionInternal(e, new Response(null, e.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
