package com.codetogive.patatasfritas.security;

import com.codetogive.patatasfritas.users.User;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


public class MyUserDetails implements UserDetails {

  private final String username;
  private final String password;
  private final String role;
  private List<GrantedAuthority> authorities;


  public MyUserDetails(User user) {
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.role = user.getRole();
    this.authorities = Arrays.stream(user.getRole().toString().split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public String getRole() {
    return role;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}