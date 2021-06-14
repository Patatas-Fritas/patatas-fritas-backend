package com.codetogive.patatasfritas.games.hotspot;

import com.codetogive.patatasfritas.games.hotspot.rectangle.Rectangle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotspotResponseDTO {
  private String image;
  private Rectangle rectangle;
}
