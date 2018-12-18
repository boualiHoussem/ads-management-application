package com.hbo.advertiser.controllers;

import com.hbo.advertiser.Exceptions.CategoryNotFoundException;
import com.hbo.advertiser.documents.Category;
import com.hbo.advertiser.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private ICategoryRepository categoryRepo;

    @Autowired
    public CategoryController(ICategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) throws CategoryNotFoundException {
        if (category != null) {
            return categoryRepo.save(category);
        }
        return null;
    }

    @PutMapping("/update/{id}")
    public void updateCategory(@PathVariable(name = "id") Long id, @RequestBody Category category) throws CategoryNotFoundException {
        Category c = categoryRepo.getByIdCategory(id);
        if (c != null) {
            categoryRepo.save(category);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable(name = "id") Long id) throws CategoryNotFoundException {
        Category c = categoryRepo.getByIdCategory(id);
        if (c != null) {
            categoryRepo.delete(c);
        }
    }

    @GetMapping("/get/{id}")
    public Category getCategory(@PathVariable(name = "id") Long id) {
        Category c = categoryRepo.getByIdCategory(id);
        if (c!=null) {
            return c;
        }
        return null;
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
