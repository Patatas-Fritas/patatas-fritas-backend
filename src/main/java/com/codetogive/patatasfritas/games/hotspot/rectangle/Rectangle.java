package com.codetogive.patatasfritas.games.hotspot.rectangle;

import com.codetogive.patatasfritas.games.hotspot.Hotspot;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rectangles")
public class Rectangle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int x;

  private int y;

  private int width;

  private int height;

  @JsonIgnore
  @OneToOne(mappedBy = "rectangle")
  private Hotspot hotspot;

}
