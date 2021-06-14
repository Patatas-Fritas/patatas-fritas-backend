package com.codetogive.patatasfritas.playbuddies.dtos;

import com.codetogive.patatasfritas.playbuddies.PlayBuddy;
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

  public PetStatusDTO(PlayBuddy playBuddy) {
    this.petId = playBuddy.getId();
    this.petName = playBuddy.getName();
    this.isHungry = false;
    int difference = 12 * 60 * 60 * 1000;
    if (Timestamp.valueOf(LocalDateTime.now()).getTime() - playBuddy.getLastFeeding().getTime()
        > difference) {
      isHungry = true;
    }
  }
}
