package com.codetogive.patatasfritas.playbuddies;

import com.codetogive.patatasfritas.playbuddies.dtos.PetChooserDTO;
import com.codetogive.patatasfritas.users.User;
import com.codetogive.patatasfritas.users.UserService;
import com.codetogive.patatasfritas.users.exceptions.NoSuchUserException;
import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    Buddy buddy = buddyRepository.findById(petChooserDTO.getPetId())
        .orElseThrow(() -> new NoSuchBuddyException(petChooserDTO.getPetId()));
    User user = userService.findUserByUsername(principal.getName());
    user.getPlayBuddy().setName(petChooserDTO.getPetName());
    user.getPlayBuddy().setLastFeeding(Timestamp.valueOf(LocalDateTime.now()));
    user.getPlayBuddy().setBuddy(buddy);
    return userService.saveUser(user).getPlayBuddy();
  }

  public PlayBuddy getPetStatus(Principal principal) throws NoSuchUserException {
    User user = userService.findUserByUsername(principal.getName());
    PlayBuddy playBuddy = user.getPlayBuddy();
    return playBuddy;
  }

  public PlayBuddy feedPet(Principal principal) throws NoSuchUserException {
    User user = userService.findUserByUsername(principal.getName());
    PlayBuddy playBuddy = user.getPlayBuddy();
    int difference = 12 * 60 * 60 * 1000;
    if ((Timestamp.valueOf(LocalDateTime.now()).getTime() - playBuddy.getLastFeeding().getTime()
        > difference) && user.getScore().getSum() >= 5) {
      user.getScore().setSum(user.getScore().getSum() - 5);
      user.getPlayBuddy().setLastFeeding(Timestamp.valueOf(LocalDateTime.now()));
    }
    return userService.saveUser(user).getPlayBuddy();
  }
}