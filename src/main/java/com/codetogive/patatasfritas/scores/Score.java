package com.codetogive.patatasfritas.scores;

import com.codetogive.patatasfritas.playbuddies.PlayBuddy;
import com.codetogive.patatasfritas.users.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "scores")
public class Score {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int sum;

  private Timestamp lastUsed;

  @OneToOne(mappedBy = "score")
  private User user;

  @OneToOne(mappedBy = "score")
  @JsonManagedReference
  private PlayBuddy playBuddy;

  public Score() {
    this.sum = 0;
    this.lastUsed = Timestamp.valueOf(LocalDateTime.now());
  }
}
