package com.codetogive.patatasfritas.playbuddies;

import com.codetogive.patatasfritas.scores.Score;
import com.codetogive.patatasfritas.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "play_buddy")
public class PlayBuddy {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "score_id")
  private Score score;

  @Column(name = "last_feeding")
  private Timestamp lastFeeding;

  private String name;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="buddy_id")
  @JsonBackReference
  private Buddy buddy;

  @OneToOne(mappedBy = "playBuddy")
  private User user;

  public PlayBuddy() {
  }
}