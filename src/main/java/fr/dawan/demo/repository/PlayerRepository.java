package fr.dawan.demo.repository;

import fr.dawan.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long>
 { }