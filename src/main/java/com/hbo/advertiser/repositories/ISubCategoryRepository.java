package com.hbo.advertiser.repositories;

import com.hbo.advertiser.documents.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubCategoryRepository extends MongoRepository<SubCategory, Long> {

    public SubCategory getByIdSubCategory(Long id);
}
