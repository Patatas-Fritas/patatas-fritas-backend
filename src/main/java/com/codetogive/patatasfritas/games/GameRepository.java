package com.codetogive.patatasfritas.games;

import com.codetogive.patatasfritas.users.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
  Optional<User> findById();

}
