package com.hbo.advertiser.controllers;

import com.hbo.advertiser.Exceptions.PhotoNotFoundException;
import com.hbo.advertiser.documents.Photo;
import com.hbo.advertiser.repositories.IPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    private IPhotoRepository photoRepo;

    @Autowired
    public PhotoController(IPhotoRepository photoRepo) {
        this.photoRepo = photoRepo;
    }

    @PostMapping("/add")
    public Photo addPhoto(@RequestBody Photo photo) throws PhotoNotFoundException {
        if (photo != null) {
            return photoRepo.save(photo);
        }
        return null;
    }

    @PutMapping("/update/{id}")
    public void updatePhoto(@PathVariable(name = "id") Long id, @RequestBody Photo photo) throws PhotoNotFoundException {
        Photo p = photoRepo.getByIdPhoto(id);
        if (p != null) {
            photoRepo.save(photo);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deletePhoto(@PathVariable(name = "id") Long id) throws PhotoNotFoundException {
        Photo p = photoRepo.getByIdPhoto(id);
        if (p != null) {
            photoRepo.delete(p);
        }
    }

    @GetMapping("/get/{id}")
    public Photo getPhoto(@PathVariable(name = "id") Long id) {
        Photo p = photoRepo.getByIdPhoto(id);
        if (p!=null) {
            return p;
        }
        return null;
    }

    @GetMapping("/all")
    public List<Photo> getAllSubCategories() {
        return photoRepo.findAll();
    }
}
