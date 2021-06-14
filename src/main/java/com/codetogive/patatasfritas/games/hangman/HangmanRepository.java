package com.codetogive.patatasfritas.games.hangman;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface HangmanRepository extends CrudRepository<Hangman, Long> {

  Optional<Hangman> findById(Long id);
}
