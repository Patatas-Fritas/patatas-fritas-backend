package com.codetogive.patatasfritas.exceptions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExceptionUtil {
  public static List<String> findMissingParameters(Object object)
      throws IllegalAccessException {
    List<String> missingParameters = new ArrayList<>();
    for (Field f : object.getClass().getDeclaredFields()) {
      f.setAccessible(true);
      if ((f.get(object) == null || f.get(object) == "")) {
        missingParameters.add(f.getName());
      }
    }
    return missingParameters;
  }
}
