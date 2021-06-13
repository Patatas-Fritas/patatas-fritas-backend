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
  public HttpStatus saveNewGame(@RequestBody WordsDTO wordsDTO) {
    Words words = mapDtoToWords(wordsDTO);
    Game game = mapDtoToGame(wordsDTO);
    game.setGameType(gameService.getGameType(1L));
    hangmanService.saveWords(words);
    gameService.saveGame(game);
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

  private Words mapDtoToWords(WordsDTO wordsDTO) {
    Words words = new Words();
    words.setWordList(wordsDTO.getWords());
    return words;
  }

  private TextsDTO mapWordsToDTO(List<String> words) {
    TextsDTO dto = new TextsDTO();
    dto.setTexts(words);
    return dto;
  }

  private Game mapDtoToGame(WordsDTO wordsDTO) {
    Game game = new Game();
    game.setTitle(wordsDTO.getTitle());
    return game;
  }
}
