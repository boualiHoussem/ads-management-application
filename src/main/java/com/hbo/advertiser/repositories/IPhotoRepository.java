package com.hbo.advertiser.repositories;

import com.hbo.advertiser.documents.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhotoRepository extends MongoRepository<Photo, Long> {
    public Photo getByIdPhoto(Long id);
}
