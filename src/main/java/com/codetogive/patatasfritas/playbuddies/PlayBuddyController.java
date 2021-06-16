package com.codetogive.patatasfritas.playbuddies;

import com.codetogive.patatasfritas.playbuddies.dtos.PetChooserDTO;
import com.codetogive.patatasfritas.playbuddies.dtos.PetChooserSuccessDTO;
import com.codetogive.patatasfritas.playbuddies.dtos.PetStatusDTO;
import com.codetogive.patatasfritas.users.User;
import com.codetogive.patatasfritas.users.UserService;
import com.codetogive.patatasfritas.users.exceptions.NoSuchUserException;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PlayBuddyController {

  @Autowired
  PlayBuddyService playBuddyService;
  @Autowired
  UserService userService;

  @PostMapping("/petchooser")
  public ResponseEntity<PetChooserSuccessDTO> savePet(@RequestBody PetChooserDTO petChooserDTO,
                                                      Principal principal)
      throws NoSuchUserException, NoSuchBuddyException {
    PlayBuddy playBuddy = playBuddyService.savePlayBuddy(petChooserDTO, principal);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new PetChooserSuccessDTO(playBuddy));
  }

  @GetMapping("/petfeeder")
  public ResponseEntity<PetStatusDTO> renderPetStatus(Principal principal)
      throws NoSuchUserException {
    PlayBuddy playBuddy = playBuddyService.getPetStatus(principal);
    User user = userService.findUserByUsername(principal.getName());
    return ResponseEntity.status(HttpStatus.OK)
        .body(new PetStatusDTO(playBuddy, user.getScore()));
  }

  @PostMapping("/petfeeder")
  public ResponseEntity<PetStatusDTO> feedPet(Principal principal)
      throws NoSuchUserException {
    PlayBuddy playBuddy = playBuddyService.feedPet(principal);
    User user = userService.findUserByUsername(principal.getName());
    return ResponseEntity.status(HttpStatus.OK)
        .body(new PetStatusDTO(playBuddy, user.getScore()));
  }
}
