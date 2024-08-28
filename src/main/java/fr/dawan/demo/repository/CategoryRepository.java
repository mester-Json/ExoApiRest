package fr.dawan.demo.repository;

import fr.dawan.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> 
 { }