package com.hbo.advertiser.repositories;

import com.hbo.advertiser.documents.Ad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdRepository extends MongoRepository<Ad, Long> {
    public Ad getByIdAd(Long id);
}
