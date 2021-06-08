package com.codetogive.patatasfritas.games.hangman;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface WordsRepository extends CrudRepository<Words, Long> {

  Optional<Words> findById(Long id);
}
