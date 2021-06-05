package com.codetogive.patatasfritas.users;

import com.codetogive.patatasfritas.security.MyUserDetailsService;
import com.codetogive.patatasfritas.users.dtos.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private MyUserDetailsService myUserDetailsService;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

  public String authenticateExistingUser(LoginRequestDTO loginRequestDTO) {
    UserDetails userDetails =
        myUserDetailsService.loadUserByUsername(loginRequestDTO.getUsername());
//    return jwtUtil.generateToken(userDetails);
    return "token";
  }

}
