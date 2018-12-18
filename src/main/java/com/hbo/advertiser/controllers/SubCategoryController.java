package com.hbo.advertiser.controllers;

import com.hbo.advertiser.Exceptions.SubCategoryNotFoundException;
import com.hbo.advertiser.documents.SubCategory;
import com.hbo.advertiser.repositories.ISubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subCategory")
public class SubCategoryController {

    private ISubCategoryRepository subCatRepo;

    @Autowired
    public SubCategoryController(ISubCategoryRepository subCatRepo) {
        this.subCatRepo = subCatRepo;
    }

    @PostMapping("/add")
    public SubCategory addSubCategory(@RequestBody SubCategory subCategory) throws SubCategoryNotFoundException {
        if (subCategory != null) {
            return subCatRepo.save(subCategory);
        }
        return null;
    }

    @PutMapping("/update/{id}")
    public void updateSubCategory(@PathVariable(name = "id") Long id, @RequestBody SubCategory subCategory) throws SubCategoryNotFoundException {
        SubCategory c = subCatRepo.getByIdSubCategory(id);
        if (c != null) {
            subCatRepo.save(subCategory);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubCategory(@PathVariable(name = "id") Long id) throws SubCategoryNotFoundException {
        SubCategory c = subCatRepo.getByIdSubCategory(id);
        if (c != null) {
            subCatRepo.delete(c);
        }
    }

    @GetMapping("/get/{id}")
    public SubCategory getSubCategory(@PathVariable(name = "id") Long id) {
        SubCategory c = subCatRepo.getByIdSubCategory(id);
        if (c!=null) {
            return c;
        }
        return null;
    }

    @GetMapping("/all")
    public List<SubCategory> getAllSubCategories() {
        return subCatRepo.findAll();
    }
}
