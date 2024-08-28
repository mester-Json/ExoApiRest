package fr.dawan.demo.repository;

import fr.dawan.demo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> { }