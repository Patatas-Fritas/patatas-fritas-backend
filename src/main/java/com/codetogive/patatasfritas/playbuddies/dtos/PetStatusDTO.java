package com.codetogive.patatasfritas.playbuddies.dtos;

import com.codetogive.patatasfritas.playbuddies.PlayBuddy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class PetStatusDTO {
  private long petId;
  private String petName;
  private Boolean isHungry;

  public PetStatusDTO(PlayBuddy playBuddy){
    //this.isHungry= ide kéne ez a 12 órás check
  }
}
