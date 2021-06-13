package com.codetogive.patatasfritas.scores;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScoreController {

  @Autowired
  ScoreService scoreService;

  @GetMapping("/score")
  public ResponseEntity<ScoreDTO> getScore(Principal principal) {
    int sum = scoreService.getSum(principal.getName());
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ScoreDTO(sum));
  }

  @GetMapping("/calculate_score")
  public ResponseEntity<ScoreDTO> calculateScore(Principal principal,
                                                 @RequestParam int numberOfGoodAnswers) {
    Score score = scoreService.getScore(principal.getName());
    int extraPointsForSubmit = 1;
    score.setSum(score.getSum() + numberOfGoodAnswers + extraPointsForSubmit);
    scoreService.saveScore(score);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ScoreDTO(score.getSum()));
  }
}
