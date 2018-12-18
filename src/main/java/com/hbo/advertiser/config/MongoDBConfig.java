package com.hbo.advertiser.config;

import com.hbo.advertiser.documents.Ad;
import com.hbo.advertiser.documents.User;
import com.hbo.advertiser.repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@EnableMongoRepositories("com.hbo.advertiser.repositories")
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(IUserRepository userRepository) {
        return args -> {
            userRepository.save(new User(1L, "user", "test", null, "sousse", 1357L, "mail", "admin", "admin", "avatar", null));
        };
    }
}
