package com.codetogive.patatasfritas.exceptions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExceptionUtil {
  public static List<String> findMissingParameters(Object object, List<String> ignoredFields)
      throws IllegalAccessException {
    List<String> missingParameters = new ArrayList<>();
    for (Field f : object.getClass().getDeclaredFields()) {
      f.setAccessible(true);
      if ((f.get(object) == null || f.get(object) == "")
          && !ignoredFields.contains(f.getName())) {
        missingParameters.add(f.getName());
      }
    }
    return missingParameters;
  }
}
