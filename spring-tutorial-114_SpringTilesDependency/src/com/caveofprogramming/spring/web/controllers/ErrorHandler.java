package com.caveofprogramming.spring.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)  // 409
//    @ExceptionHandler(Exception.class)
    public String handleConflict() {
        return "error";
    }
    
    @ResponseStatus(HttpStatus.CONFLICT)  // 409
  @ExceptionHandler(AccessDeniedException.class)
  public String handleAccessDeniedException() {
      return "denied";
  }
}