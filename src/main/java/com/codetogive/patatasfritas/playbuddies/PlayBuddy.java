package com.codetogive.patatasfritas.playbuddies;

import java.security.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PlayBuddy {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private int score;

  private Timestamp lastFeeding;
}