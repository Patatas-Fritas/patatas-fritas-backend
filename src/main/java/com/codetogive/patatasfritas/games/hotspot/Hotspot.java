package com.codetogive.patatasfritas.games.hotspot;

import com.codetogive.patatasfritas.games.hotspot.rectangle.Rectangle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "hotspots")
public class Hotspot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String image;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rectangles_id")
  @JsonBackReference
  private Rectangle rectangle;

}
