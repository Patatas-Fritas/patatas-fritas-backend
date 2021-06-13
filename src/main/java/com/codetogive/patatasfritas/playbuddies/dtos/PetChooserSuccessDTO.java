package com.codetogive.patatasfritas.playbuddies.dtos;

import com.codetogive.patatasfritas.playbuddies.PlayBuddy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PetChooserSuccessDTO {
  private long playBuddyId;
  private String name;
  private Long buddyId;

  public PetChooserSuccessDTO(PlayBuddy playBuddy) {
    this.playBuddyId = playBuddy.getId();//itt a buddyId-t is vissza kéne adni
    this.name = playBuddy.getName();
    this.buddyId = playBuddy.getBuddy().getId();
  }
}
