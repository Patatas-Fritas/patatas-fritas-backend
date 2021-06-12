package com.codetogive.patatasfritas.playbuddies;

import com.codetogive.patatasfritas.playbuddies.dtos.PetChooserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayBuddyController {

  @PostMapping("/petchooser")
  public ResponseEntity<HttpStatus> savePet(@RequestBody PetChooserDTO petChooserDTO){
    System.out.println(petChooserDTO.getPetId());
    System.out.println(petChooserDTO.getPetName());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
