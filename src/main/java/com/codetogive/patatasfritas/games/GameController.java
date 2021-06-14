package com.codetogive.patatasfritas.games;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

  @Autowired
  GameService gameService;

  @GetMapping("/games")
  public ResponseEntity<List<GameDTO>> getGames() {
    List<Game> games = gameService.getGames();
    List<GameDTO> gameDTOList =
        games.stream().map(this::mapGameToDTO).collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK)
        .body(gameDTOList);
  }

  private GameDTO mapGameToDTO(Game game) {
    GameDTO gameDTO = new GameDTO();
    gameDTO.setId(game.getId());
    gameDTO.setTitle(game.getTitle());
    gameDTO.setDescription(game.getGameType().getDescription());
    gameDTO.setType(game.getGameType().getType());
    return gameDTO;
  }
}
