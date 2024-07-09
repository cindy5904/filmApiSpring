package org.example.film2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

public class GeneralExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundExceptionHandler (NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No entity found");
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<String> dateTimeParseExceptionHandler (DateTimeParseException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("date string must be dd-MM-yyyy");
    }
}
