package com.example.marketplaceapi.database;

//import org.apache.catalina.User;

import com.example.marketplaceapi.database.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
