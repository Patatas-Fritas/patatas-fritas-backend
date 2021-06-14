package com.codetogive.patatasfritas.games.hotspot;

import com.codetogive.patatasfritas.games.Game;
import com.codetogive.patatasfritas.games.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotspotController {

  @Autowired
  HotspotService hotspotService;

  @Autowired
  GameService gameService;

  @PostMapping("/hotspot/save")
  public HttpStatus saveNewGame(@RequestBody HotspotDTO hotspotDTO) {
    Hotspot hotspot = mapDtoToHotspot(hotspotDTO);
    Game game = mapDtoToGame(hotspotDTO);
    game.setGameType(gameService.getGameType(2L));
    hotspotService.saveHotspot(hotspot);
    gameService.saveGame(game);
    return HttpStatus.OK;
  }

  @GetMapping("/hotspot/get")
  public ResponseEntity<HotspotResponseDTO> getHotSpot(@RequestParam Long id) {
    Hotspot hotspot = hotspotService.getHotspot(id);
    HotspotResponseDTO hotspotResponseDTO = mapHotspotToDTO(hotspot);
    return ResponseEntity.status(HttpStatus.OK)
        .body(hotspotResponseDTO);
  }

  private Hotspot mapDtoToHotspot(HotspotDTO hotspotDTO) {
    Hotspot hotspot = new Hotspot();
    hotspot.setImage(hotspotDTO.getImage());
    hotspot.setRectangle(hotspotDTO.getRectangle());
    return hotspot;
  }

  private Game mapDtoToGame(HotspotDTO hotspotDTO) {
    Game game = new Game();
    game.setTitle(hotspotDTO.getTitle());
    return game;
  }

  private HotspotResponseDTO mapHotspotToDTO(Hotspot hotspot) {
    HotspotResponseDTO hotspotResponseDTO = new HotspotResponseDTO();
    hotspotResponseDTO.setImage(hotspot.getImage());
    hotspotResponseDTO.setRectangle(hotspot.getRectangle());
    return hotspotResponseDTO;
  }
}
