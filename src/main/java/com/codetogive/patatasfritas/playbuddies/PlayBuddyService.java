package com.codetogive.patatasfritas.playbuddies;

import com.codetogive.patatasfritas.playbuddies.dtos.PetChooserDTO;
import com.codetogive.patatasfritas.users.User;
import com.codetogive.patatasfritas.users.UserService;
import com.codetogive.patatasfritas.users.exceptions.NoSuchUserException;
import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayBuddyService {

  @Autowired
  PlayBuddyRepository playBuddyRepository;

  @Autowired
  BuddyRepository buddyRepository;

  @Autowired
  UserService userService;

  public PlayBuddy savePlayBuddy(PetChooserDTO petChooserDTO, Principal principal)
      throws NoSuchUserException, NoSuchBuddyException {
    Buddy buddy = buddyRepository.findById(petChooserDTO.getPetId()).orElseThrow(() -> new NoSuchBuddyException(petChooserDTO.getPetId()));
    User user = userService.findUserByUsername(principal.getName());
    user.getPlayBuddy().setName(petChooserDTO.getPetName());
    user.getPlayBuddy().setLastFeeding(Timestamp.valueOf(LocalDateTime.now()));
    user.getPlayBuddy().setBuddy(buddy);
    return userService.saveUser(user).getPlayBuddy();
  }
}
