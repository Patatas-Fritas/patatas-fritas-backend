package com.codetogive.patatasfritas.games.hangman;

import com.codetogive.patatasfritas.games.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "hangmans")
public class Hangman {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "hangman", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Word> wordList;

  @JsonIgnore
  @OneToOne(mappedBy = "hangman",  cascade = CascadeType.ALL)
  private Game game;
}
