package com.codetogive.patatasfritas.scores;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

  @Autowired
  ScoreRepsitory scoreRepsitory;

  public int getSum(String name) {
    Score score = scoreRepsitory.findByUserUsername(name).orElseThrow(NoSuchElementException::new);
    return score.getSum();
  }

  public Score getScore(String name) {
    return scoreRepsitory.findByUserUsername(name).orElseThrow(NoSuchElementException::new);
  }

  public void saveScore(Score score) {
    scoreRepsitory.save(score);
  }
}
