package com.codetogive.patatasfritas.games.hotspot;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotspotService {

  @Autowired
  HotspotRepository hotspotRepository;

  public void saveHotspot(Hotspot hotspot) {
    hotspotRepository.save(hotspot);
  }

  public Hotspot getHotspot(Long id) {
    return hotspotRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }
}
