package com.codetogive.patatasfritas.users.dtos;

import lombok.Getter;

@Getter
public class LoginSuccessDTO {

  private final String status;
  private final String token;

  public LoginSuccessDTO(String jwt) {
    this.status = "ok";
    this.token = jwt;
  }
}
