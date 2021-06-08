package com.codetogive.patatasfritas.games.hangman;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HangmanService {
  @Autowired
  WordsRepository wordsRepository;

  public void saveWords(Words words) {
    wordsRepository.save(words);
  }

  public Words getWords(Long id) {
    return wordsRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }
}
