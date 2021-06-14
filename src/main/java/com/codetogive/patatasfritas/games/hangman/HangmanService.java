package com.codetogive.patatasfritas.games.hangman;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HangmanService {
  @Autowired
  HangmanRepository hangmanRepository;

  public void saveWords(Hangman hangman) {
    hangmanRepository.save(hangman);
  }

  public Hangman getWords(Long id) {
    return hangmanRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }
}
