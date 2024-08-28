package fr.dawan.demo.controller;

import fr.dawan.demo.dto.PlayerDto;
import fr.dawan.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players") 
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    public PlayerService getPlayerService() {
        return playerService;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(
   @PathVariable Long id) {
        PlayerDto playerDto = playerService.getPlayerById(id);
        return ResponseEntity.ok(playerDto); 
    }

}