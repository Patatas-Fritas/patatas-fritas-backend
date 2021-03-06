package com.codetogive.patatasfritas.users;

import com.codetogive.patatasfritas.exceptions.MissingRequiredParameterException;
import com.codetogive.patatasfritas.playbuddies.PlayBuddy;
import com.codetogive.patatasfritas.scores.Score;
import com.codetogive.patatasfritas.users.dtos.LoginRequestDTO;
import com.codetogive.patatasfritas.users.dtos.LoginSuccessDTO;
import com.codetogive.patatasfritas.users.dtos.UserRequestDTO;
import com.codetogive.patatasfritas.users.exceptions.NoSuchUserException;
import com.codetogive.patatasfritas.users.exceptions.OccupiedUsernameException;
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
  UserService userService;

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/")
  public String home() {
    return "hello";
  }

  @PostMapping("/login")
  public ResponseEntity<LoginSuccessDTO> login(@RequestBody LoginRequestDTO loginRequestDTO)
      throws IllegalAccessException, NoSuchUserException, MissingRequiredParameterException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new LoginSuccessDTO(userService.authenticateExistingUser(loginRequestDTO),
            userService.findUserByUsername(loginRequestDTO.getUsername())));
  }

  @GetMapping("/k")
  public String k() {
    return "you are USER";
  }

  @PostMapping("/register")
  public HttpStatus register(@RequestBody UserRequestDTO userRequestDTO)
      throws IllegalAccessException, OccupiedUsernameException, MissingRequiredParameterException {
    userService.validateUser(userRequestDTO);
    User user = mapDtoToUser(userRequestDTO);
    userService.saveUser(user);
    return HttpStatus.OK;
  }

  private User mapDtoToUser(UserRequestDTO userRequestDTO) {
    User user = new User();
    user.setFirstName(userRequestDTO.getFirstName());
    user.setLastName(userRequestDTO.getLastName());
    user.setUsername(userRequestDTO.getUsername());
    user.setEmailAddress(userRequestDTO.getEmail());
    user.setPassword(userRequestDTO.getPassword());
    user.setRole("ROLE_USER");
    user.setPlayBuddy(new PlayBuddy());
    user.setScore(new Score());
    return user;
  }

}
