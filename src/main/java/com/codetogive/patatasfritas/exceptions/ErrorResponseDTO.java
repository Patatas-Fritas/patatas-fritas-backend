package com.codetogive.patatasfritas.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponseDTO {
  private final String status;
  private final String message;

  public ErrorResponseDTO(String message) {
    this.status = "error";
    this.message = message;
  }
}
