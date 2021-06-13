package com.codetogive.patatasfritas.playbuddies;

import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuddyRepository extends CrudRepository<Buddy, Long> {
  @NotNull
  Optional<Buddy> findById(Long id);
}
