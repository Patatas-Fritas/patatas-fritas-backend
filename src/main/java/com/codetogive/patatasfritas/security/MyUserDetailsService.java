package com.codetogive.patatasfritas.security;

import com.codetogive.patatasfritas.users.User;
import com.codetogive.patatasfritas.users.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  //username legyen az id (plusz validálás, hogy egyedi legyen)
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findUserByUsername(username);

    user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

    return user.map(MyUserDetails::new).get();
  }


}
