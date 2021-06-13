package com.codetogive.patatasfritas.users;

import com.codetogive.patatasfritas.playbuddies.PlayBuddy;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.codetogive.patatasfritas.scores.Score;
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
  private String username;

  private String firstName;

  private String lastName;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @Column(name = "email")
  private String emailAddress;

  @Column(name = "roles")
  private String role;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "play_buddy_id")
  @JsonBackReference
  private PlayBuddy playBuddy;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "score_id")
  @JsonBackReference
  private Score score;

  public User(String username, String firstName, String lastName, String password,
              String emailAddress, String role) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.emailAddress = emailAddress;
    this.role = role;
    this.playBuddy=new PlayBuddy();
    this.score = new Score();
  }
}
