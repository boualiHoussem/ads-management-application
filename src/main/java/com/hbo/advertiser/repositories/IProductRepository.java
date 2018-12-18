package com.hbo.advertiser.repositories;

import com.hbo.advertiser.documents.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends MongoRepository<Product, Long> {

    public Product getByIdProduct(Long id);
}
