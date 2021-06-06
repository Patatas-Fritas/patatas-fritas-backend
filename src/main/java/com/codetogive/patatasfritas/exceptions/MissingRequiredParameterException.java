package com.codetogive.patatasfritas.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

public class MissingRequiredParameterException extends PatatasException {

  public MissingRequiredParameterException(String message) {
    super(HttpStatus.BAD_REQUEST, message);
  }

  public MissingRequiredParameterException(List<String> missingParameters) {
    super(HttpStatus.BAD_REQUEST,
        "Missing parameter(s): " + String.join(", ", missingParameters) + "!");
  }
}
