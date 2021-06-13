package com.codetogive.patatasfritas.games;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTypeRepository extends CrudRepository<GameType, Long> {
   Optional<GameType> findById(Long id);
}
