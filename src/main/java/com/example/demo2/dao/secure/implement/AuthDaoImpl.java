package com.example.demo2.dao.secure.implement;

import com.example.demo2.dao.base.BaseRepositoryImpl;
import com.example.demo2.dao.secure.interfaces.AuthDao;
import com.example.demo2.model.entity.secure.User;
import com.example.demo2.repository.secure.AuthRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AuthDaoImpl extends BaseRepositoryImpl<User, String> implements AuthDao {

    /**
     *
     */
    private final AuthRepository authRepository;

    /**
     * Constructor for injections dependencies
     *
     * @param authRepository mongo operations dependency
     */
    public AuthDaoImpl(final AuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }

    /**
     * @param username
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unused")
    public Mono<User> findByUsername(String username) throws Exception {
        /*final String usernam = "user";// password: user
        User user = new User(usernam, "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=", true, Arrays.asList(Role.ROLE_USER));
        switch (username) {
            case usernam:
                return Mono.just(user);
            default:
                return Mono.empty();
        }*/
        return this.authRepository.findByUsername(username);
    }
}
