package com.codetogive.patatasfritas.games.hangman;

import com.codetogive.patatasfritas.games.Game;
import com.codetogive.patatasfritas.games.GameService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HangmanController {

  @Autowired
  HangmanService hangmanService;

  @Autowired
  GameService gameService;

  @PostMapping("/hangman/save_word")
  public HttpStatus saveNewGame(@RequestBody HangmanDTO hangmanDTO) {
    Hangman hangman = mapDtoToWords(hangmanDTO);
    hangmanService.saveWords(hangman);
    return HttpStatus.OK;
  }

  @GetMapping("hangman/get_words")
  public ResponseEntity<TextsDTO> getWord(@RequestParam Long id) {
    List<String> words = new ArrayList<>();
    hangmanService.getWords(id).getWordList().forEach(word -> words.add(word.getText()));
    TextsDTO textsDTO = mapWordsToDTO(words);
    return ResponseEntity.status(HttpStatus.OK)
        .body(textsDTO);
  }

  private Hangman mapDtoToWords(HangmanDTO hangmanDTO) {
    Hangman hangman = new Hangman();
    hangman.setWordList(hangmanDTO.getWords());
    Game game = new Game();
    game.setTitle(hangmanDTO.getTitle());
    game.setGameType(gameService.getGameType(1L));
    hangman.setGame(game);
    return hangman;
  }

  private TextsDTO mapWordsToDTO(List<String> words) {
    TextsDTO dto = new TextsDTO();
    dto.setTexts(words);
    return dto;
  }
}
