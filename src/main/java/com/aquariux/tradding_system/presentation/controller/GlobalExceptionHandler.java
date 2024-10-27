package com.aquariux.tradding_system.presentation.controller;

import com.aquariux.tradding_system.infra.exception.UserNotFoundException;
import com.aquariux.tradding_system.presentation.dto.ResponseMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ResponseMsg> handleUserNotFoundException(UserNotFoundException ex) {
    return new ResponseEntity<>(new ResponseMsg(ex.getCode(), ex.getMessage()),
        HttpStatus.NOT_FOUND);
  }
}
