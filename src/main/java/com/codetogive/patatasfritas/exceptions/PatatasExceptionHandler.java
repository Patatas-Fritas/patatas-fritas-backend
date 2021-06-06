package com.codetogive.patatasfritas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatatasExceptionHandler {

  @ExceptionHandler(PatatasException.class)
  public ResponseEntity<ErrorResponseDTO> handleTribesException(PatatasException e) {
    ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(e.getMessage());
    return new ResponseEntity<>(errorResponseDTO, e.getHttpStatus());
  }

  @ExceptionHandler(IllegalAccessException.class)
  public ResponseEntity<Void> handleIllegalAccessException() {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<ErrorResponseDTO> handleBadCredentialsException() {
    ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO("Incorrect username or password!");
    return new ResponseEntity<>(errorResponseDTO, HttpStatus.FORBIDDEN);
  }
}

