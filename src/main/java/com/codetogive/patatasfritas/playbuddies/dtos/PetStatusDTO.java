package com.codetogive.patatasfritas.playbuddies.dtos;

import com.codetogive.patatasfritas.playbuddies.PlayBuddy;
import com.codetogive.patatasfritas.scores.Score;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class PetStatusDTO {
  private long petId;
  private String petName;
  private Boolean isHungry;
  private int petScore;

  public PetStatusDTO(PlayBuddy playBuddy, Score score) {
    this.petId = playBuddy.getId();
    this.petName = playBuddy.getName();
    this.isHungry = false;
    int difference = 12 * 60 * 60 * 1000;
    if (Timestamp.valueOf(LocalDateTime.now()).getTime() - playBuddy.getLastFeeding().getTime()
        > difference) {
      isHungry = true;
    }
    this.petScore=score.getSum();
  }
}
