package com.codetogive.patatasfritas.playbuddies;

import com.codetogive.patatasfritas.playbuddies.dtos.PetChooserDTO;
import com.codetogive.patatasfritas.playbuddies.dtos.PetChooserSuccessDTO;
import com.codetogive.patatasfritas.users.exceptions.NoSuchUserException;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PlayBuddyController {

  @Autowired
  PlayBuddyService playBuddyService;

  @PostMapping("/petchooser")
  public ResponseEntity<PetChooserSuccessDTO> savePet(@RequestBody PetChooserDTO petChooserDTO,
                                                      Principal principal)
      throws NoSuchUserException, NoSuchBuddyException {
    PlayBuddy playBuddy = playBuddyService.savePlayBuddy(petChooserDTO, principal);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new PetChooserSuccessDTO(playBuddy));
  }
}
