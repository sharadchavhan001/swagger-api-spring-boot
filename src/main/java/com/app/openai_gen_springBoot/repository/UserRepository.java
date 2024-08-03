package com.app.openai_gen_springBoot.repository;

import com.app.openai_gen_springBoot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
