package com.codetogive.patatasfritas.users;

import com.codetogive.patatasfritas.exceptions.MissingRequiredParameterException;
import com.codetogive.patatasfritas.users.dtos.LoginRequestDTO;
import com.codetogive.patatasfritas.users.dtos.LoginSuccessDTO;
import com.codetogive.patatasfritas.users.exceptions.NoSuchUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/")
  public String home() {
    return "hello";
  }

  @PostMapping("/login")
  public ResponseEntity<LoginSuccessDTO> login(@RequestBody LoginRequestDTO loginRequestDTO)
      throws IllegalAccessException, NoSuchUserException, MissingRequiredParameterException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new LoginSuccessDTO(userService.authenticateExistingUser(loginRequestDTO)));
  }

  @GetMapping("/k")
  public String k(){return "you are USER";}
}
