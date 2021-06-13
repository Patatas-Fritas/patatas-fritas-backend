package com.codetogive.patatasfritas.games.hotspot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotspotRepository extends CrudRepository<Hotspot, Long> {
}
