package com.example.demo2.repository.secure;

import com.example.demo2.model.entity.secure.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 *
 */
@Repository
public interface AuthRepository extends ReactiveMongoRepository<User, String> {

    /**
     * @param username
     * @return
     */
    Mono<User> findByUsername(String username);
}
