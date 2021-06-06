package com.codetogive.patatasfritas.users.dtos;

import com.codetogive.patatasfritas.users.User;
import lombok.Getter;

@Getter
public class LoginSuccessDTO {

  private final String status;
  private final String token;
  private final User user;


  public LoginSuccessDTO(String jwt, User user) {
    this.status = "ok";
    this.token = jwt;
    this.user = user;
  }
}
