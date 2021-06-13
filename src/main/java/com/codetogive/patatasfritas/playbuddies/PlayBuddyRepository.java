package com.codetogive.patatasfritas.playbuddies;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayBuddyRepository extends CrudRepository<PlayBuddy, Long> {
}
