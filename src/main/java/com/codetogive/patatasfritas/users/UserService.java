package com.codetogive.patatasfritas.users;

import com.codetogive.patatasfritas.exceptions.ExceptionUtil;
import com.codetogive.patatasfritas.exceptions.MissingRequiredParameterException;
import com.codetogive.patatasfritas.security.JwtUtil;
import com.codetogive.patatasfritas.security.MyUserDetails;
import com.codetogive.patatasfritas.security.MyUserDetailsService;
import com.codetogive.patatasfritas.users.dtos.LoginRequestDTO;
import com.codetogive.patatasfritas.users.dtos.UserRequestDTO;
import com.codetogive.patatasfritas.users.exceptions.NoSuchUserException;
import com.codetogive.patatasfritas.users.exceptions.OccupiedUsernameException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


  @Autowired
  private MyUserDetailsService myUserDetailsService;
  @Autowired
  private JwtUtil jwtUtil;
  @Autowired
  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public String authenticateExistingUser(LoginRequestDTO loginRequestDTO)
      throws IllegalAccessException, NoSuchUserException, MissingRequiredParameterException {
    validateRequestDTO(loginRequestDTO);
    authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),
            loginRequestDTO.getPassword()));
    MyUserDetails userDetails =
        myUserDetailsService.loadUserByUsername(loginRequestDTO.getUsername());
    return jwtUtil.generateToken(userDetails);
  }

  private void validateRequestDTO(LoginRequestDTO loginRequestDTO)
      throws MissingRequiredParameterException, NoSuchUserException,
      IllegalAccessException {
    if (!ExceptionUtil.findMissingParameters(loginRequestDTO).isEmpty()) {
      throw new MissingRequiredParameterException(
          buildMissingLoginParameterMessage(loginRequestDTO));
    } else if (!isUsernameOccupied(loginRequestDTO.getUsername())) {
      throw new NoSuchUserException((loginRequestDTO.getUsername()));
    }
  }

  public String buildMissingLoginParameterMessage(LoginRequestDTO loginRequestDTO)
      throws IllegalAccessException {
    return "Missing parameter(s): " +
        String.join(", ", ExceptionUtil.findMissingParameters(loginRequestDTO));
  }

  public void validateUser(UserRequestDTO userRequestDTO)
      throws IllegalAccessException, MissingRequiredParameterException, OccupiedUsernameException {
    if (userRequestDTO == null) {
      UserRequestDTO userRequestDtoWithNullParameters = new UserRequestDTO();
      ExceptionUtil.findMissingParameters(userRequestDtoWithNullParameters);
      throw new MissingRequiredParameterException(createErrorMessageForMissingRequiredParameters(
          userRequestDtoWithNullParameters));
    } else if (!ExceptionUtil
        .findMissingParameters(userRequestDTO)
        .isEmpty()) {
      throw new MissingRequiredParameterException(
          createErrorMessageForMissingRequiredParameters(userRequestDTO));
    } else if (isUsernameOccupied(userRequestDTO.getUsername())) {
      throw new OccupiedUsernameException();
    }
  }

  private String createErrorMessageForMissingRequiredParameters(
      UserRequestDTO userRequestDTO) throws IllegalAccessException {
    List<String> missingParameters =
        ExceptionUtil.findMissingParameters(userRequestDTO);
    return "Missing parameter(s): " + String.join(", ", missingParameters) + "!";
  }

  private boolean isUsernameOccupied(String username) {
    return userRepository.existsUserByUsername(username);
  }


  public User findUserByUsername(String username) throws NoSuchUserException {
    return userRepository.findUserByUsername(username)
        .orElseThrow(() -> new NoSuchUserException(username));
  }

}