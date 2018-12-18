package com.hbo.advertiser.controllers;

import com.hbo.advertiser.Exceptions.ProductNotFoundException;
import com.hbo.advertiser.documents.Product;
import com.hbo.advertiser.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private IProductRepository productRepo;

    @Autowired
    public ProductController(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) throws ProductNotFoundException {
        if (product != null) {
            return productRepo.save(product);
        }
        return null;
    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable(name = "id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        Product p = productRepo.getByIdProduct(id);
        if (p != null) {
            productRepo.save(product);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) throws ProductNotFoundException {
        Product p = productRepo.getByIdProduct(id);
        if (p != null) {
            productRepo.delete(p);
        }
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable(name = "id") Long id) {
        Product p = productRepo.getByIdProduct(id);
        if (p!=null) {
            return p;
        }
        return null;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
