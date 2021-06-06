package com.codetogive.patatasfritas.users.exceptions;

import com.codetogive.patatasfritas.exceptions.PatatasException;
import org.springframework.http.HttpStatus;

public class NoSuchUserException extends PatatasException {

  public NoSuchUserException(String username) {
    super(HttpStatus.UNAUTHORIZED, "No such user: " + username + "!");
  }
}
