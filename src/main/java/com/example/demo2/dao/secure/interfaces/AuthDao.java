package com.example.demo2.dao.secure.interfaces;

import com.example.demo2.dao.base.BaseRepository;
import com.example.demo2.model.entity.secure.User;
import reactor.core.publisher.Mono;

/**
 *
 */
public interface AuthDao extends BaseRepository<User, String> {
    /**
     * @param username
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unused")
    public Mono<User> findByUsername(String username) throws Exception;
}
