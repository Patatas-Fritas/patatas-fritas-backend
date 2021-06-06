package com.codetogive.patatasfritas.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class PatatasException extends Exception {

  private final HttpStatus httpStatus;

  public PatatasException(HttpStatus httpStatus, String message) {
    super(message);
    this.httpStatus = httpStatus;
  }
}
