package com.codetogive.patatasfritas.games.hotspot.rectangle;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RectangleRepository extends CrudRepository<Rectangle, Long> {
  Optional<Rectangle> findById(Long id);
}
