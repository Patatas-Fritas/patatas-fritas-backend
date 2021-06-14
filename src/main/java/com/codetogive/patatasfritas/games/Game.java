package com.codetogive.patatasfritas.games;

import com.codetogive.patatasfritas.games.hangman.Hangman;
import com.codetogive.patatasfritas.games.hotspot.Hotspot;
import com.codetogive.patatasfritas.games.hotspot.rectangle.Rectangle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "games")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "game_type_id")
  @JsonBackReference
  private GameType gameType;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "hotspots_id")
  @JsonBackReference
  private Hotspot hotspot;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "hangmans_id")
  @JsonBackReference
  private Hangman hangman;
}
