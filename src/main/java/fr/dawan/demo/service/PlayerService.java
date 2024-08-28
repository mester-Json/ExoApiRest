package fr.dawan.demo.service;

import fr.dawan.demo.dto.PlayerDto;
import fr.dawan.demo.entity.Manager;
import fr.dawan.demo.entity.Player;
import fr.dawan.demo.repository.ManagerRepository;
import fr.dawan.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ManagerRepository managerRepository;

    public PlayerDto getPlayerById(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            String managerName = player.getManager() != null ? player.getManager().getName() : null; 
            return new PlayerDto(player.getId(), player.getName(), managerName); 
        } else {
            throw new RuntimeException("Joueur non trouvé avec l'ID : " + id);
        }
    }

    public PlayerDto createPlayer(PlayerDto playerDto) {
    	Manager manager = managerRepository.findByName(playerDto.getManagerName())
                .orElseThrow(() -> new RuntimeException("Manager not found with name: " + playerDto.getManagerName()));

        Player player = new Player();
        player.setName(playerDto.getName());
        player.setManager(manager);

        Player savedPlayer = playerRepository.save(player);
        return new PlayerDto(savedPlayer.getId(), savedPlayer.getName(), savedPlayer.getManager().getName());
    }

    public PlayerDto updatePlayer(Long id, PlayerDto playerDto) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));

        // Find manager by name
        Manager manager = managerRepository.findByName(playerDto.getManagerName())
                .orElseThrow(() -> new RuntimeException("Manager not found with name: " + playerDto.getManagerName()));

        existingPlayer.setName(playerDto.getName());
        existingPlayer.setManager(manager);

        Player updatedPlayer = playerRepository.save(existingPlayer);
        return new PlayerDto(updatedPlayer.getId(), updatedPlayer.getName(), updatedPlayer.getManager().getName());
    }
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}