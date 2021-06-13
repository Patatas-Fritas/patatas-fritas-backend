package com.codetogive.patatasfritas.playbuddies;

import com.codetogive.patatasfritas.exceptions.PatatasException;
import org.springframework.http.HttpStatus;

public class NoSuchBuddyException extends PatatasException {

  public NoSuchBuddyException(Long buddyId) {
    super(HttpStatus.UNAUTHORIZED, "A megadott felhasználó nem létezik: " + buddyId + "!");
  }
}
