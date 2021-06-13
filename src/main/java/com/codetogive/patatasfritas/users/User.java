package com.codetogive.patatasfritas.users;

import com.codetogive.patatasfritas.playbuddies.PlayBuddy;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @Column(name = "Username")
  private String username;

  @Column(name = "First_Name")
  private String firstName;

  @Column(name = "Last_Name")
  private String lastName;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Column(name = "Password")
  private String password;

  @Column(name = "Email")
  private String emailAddress;

  @Column(name = "Roles")
  private String role;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "play_buddy_id")
  @JsonBackReference
  private PlayBuddy playBuddy;


  public User(String username, String firstName, String lastName, String password,
              String emailAddress, String role) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.emailAddress = emailAddress;
    this.role = role;
    this.playBuddy=new PlayBuddy();
  }
}
