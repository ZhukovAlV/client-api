package com.unibell.client.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse("Server Error", details);
        log.error("Unknown error occurred", ex);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ClientNotFoundException.class)
    public static ResponseEntity<Object> handleUserNotFoundException(ClientNotFoundException clientNotFoundException) {
        List<String> details = new ArrayList<>();
        details.add(clientNotFoundException.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("User Not Found", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
