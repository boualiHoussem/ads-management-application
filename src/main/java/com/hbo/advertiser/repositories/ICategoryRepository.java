package com.hbo.advertiser.repositories;

import com.hbo.advertiser.documents.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends MongoRepository<Category, Long> {
    public Category getByIdCategory(Long id);
}
