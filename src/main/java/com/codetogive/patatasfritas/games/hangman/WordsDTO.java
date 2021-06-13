package com.codetogive.patatasfritas.games.hangman;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WordsDTO {

  private String title;

  private List<Word> words;
}
