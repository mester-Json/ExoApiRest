package fr.dawan.demo.controller;


import fr.dawan.demo.dto.CategoryDto;
import fr.dawan.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

 @Autowired
 private CategoryService categoryService;

 public CategoryService getCategoryService() {
	return categoryService;
}

public void setCategoryService(CategoryService categoryService) {
	this.categoryService = categoryService;
}

@PostMapping
 public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
     CategoryDto createdCategory = categoryService.createCategory(categoryDto);
     return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
 }

 @GetMapping("/{id}")
 public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
     CategoryDto categoryDto = categoryService.getCategoryById(id);
     return ResponseEntity.ok(categoryDto);
 }

 @PutMapping("/{id}")
 public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
     CategoryDto updatedCategory = categoryService.updateCategory(id, categoryDto);
     return ResponseEntity.ok(updatedCategory);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
     categoryService.deleteCategory(id);
     return ResponseEntity.noContent().build();
 }
}