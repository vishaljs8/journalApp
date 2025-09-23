package com.vishalsingh.journalApp.repository;

import com.vishalsingh.journalApp.entity.UserEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntry, String> {
    Optional<UserEntry> findByUsername(String user);

}
