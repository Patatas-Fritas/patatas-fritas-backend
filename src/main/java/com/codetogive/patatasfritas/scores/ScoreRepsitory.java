package com.codetogive.patatasfritas.scores;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepsitory extends CrudRepository<Score, Long> {
  Optional<Score> findByUserUsername(String username);
}
