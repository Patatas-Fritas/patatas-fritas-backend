package com.codetogive.patatasfritas.games;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  @Autowired
  GameRepository gameRepository;

  @Autowired
  GameTypeRepository gameTypeRepository;

  public List<Game> getGames() {
    return gameRepository.findAll();
  }

  public GameType getGameType(Long id) {
    return gameTypeRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public void saveGame(Game game) {
    gameRepository.save(game);
  }
}
