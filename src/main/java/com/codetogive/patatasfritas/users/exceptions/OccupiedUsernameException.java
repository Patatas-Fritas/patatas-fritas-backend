package com.codetogive.patatasfritas.users.exceptions;

import com.codetogive.patatasfritas.exceptions.PatatasException;
import org.springframework.http.HttpStatus;

public class OccupiedUsernameException extends PatatasException {

  public OccupiedUsernameException() {
    super(HttpStatus.CONFLICT, "A megadott felhasználónév már foglalt. Kérlek, válassz másikat!");
  }
}
