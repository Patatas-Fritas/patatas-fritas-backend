package com.codetogive.patatasfritas.games.hotspot.rectangle;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RectangleService {

  @Autowired
  RectangleRepository rectangleRepository;

  public Rectangle getRectangle(Long id) {
    return rectangleRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public void saveRectangle(Rectangle rectangle) {
    rectangleRepository.save(rectangle);
  }
}
