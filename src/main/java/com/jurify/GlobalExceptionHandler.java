package com.jurify;

import com.jurify.service.CaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CaseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCaseNotFound(CaseNotFoundException ex) {
        return ex.getMessage();
    }
}