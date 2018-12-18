package com.hbo.advertiser.repositories;

import com.hbo.advertiser.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, Long> {
    public User getById(Long id);
}
