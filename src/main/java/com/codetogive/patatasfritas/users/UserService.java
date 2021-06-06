package com.codetogive.patatasfritas.users;

import com.codetogive.patatasfritas.exceptions.ExceptionUtil;
import com.codetogive.patatasfritas.exceptions.MissingRequiredParameterException;
import com.codetogive.patatasfritas.security.JwtUtil;
import com.codetogive.patatasfritas.security.MyUserDetailsService;
import com.codetogive.patatasfritas.users.dtos.LoginRequestDTO;
import com.codetogive.patatasfritas.users.exceptions.NoSuchUserException;
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
    UserDetails userDetails =
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

  private boolean isUsernameOccupied(String username) {
    return userRepository.existsUserByUsername(username);
  }

  public String buildMissingLoginParameterMessage(LoginRequestDTO loginRequestDTO)
      throws IllegalAccessException {
    return "Missing parameter(s): " +
        String.join(", ", ExceptionUtil.findMissingParameters(loginRequestDTO));
  }
}
