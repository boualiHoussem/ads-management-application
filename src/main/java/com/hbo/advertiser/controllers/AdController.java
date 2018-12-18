package com.hbo.advertiser.controllers;

import com.hbo.advertiser.Exceptions.AdNotFoundException;
import com.hbo.advertiser.documents.Ad;
import com.hbo.advertiser.repositories.IAdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ad")
public class AdController {

    private IAdRepository adRepo;

    @Autowired
    public AdController(IAdRepository adRepo) {
        this.adRepo = adRepo;
    }

    @PostMapping("/add")
    public Ad addAd(@RequestBody Ad ad) throws AdNotFoundException {
        if (ad != null) {
            return adRepo.save(ad);
        }
        return null;
    }

    @PutMapping("/update/{id}")
    public void updateAd(@PathVariable(name = "id") Long id, @RequestBody Ad ad) throws AdNotFoundException {
        Ad a = adRepo.getByIdAd(id);
        if (a != null) {
            adRepo.save(ad);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAd(@PathVariable(name = "id") Long id) throws AdNotFoundException {
        Ad a = adRepo.getByIdAd(id);
        if (a != null) {
            adRepo.delete(a);
        }
    }

    @GetMapping("/get/{id}")
    public Ad getAd(@PathVariable(name = "id") Long id) {
        Ad a = adRepo.getByIdAd(id);
        if (a!=null) {
            return a;
        }
        return null;
    }

    @GetMapping("/all")
    public List<Ad> getAllAds() {
        return adRepo.findAll();
    }
}
