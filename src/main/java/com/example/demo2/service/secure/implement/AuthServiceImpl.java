package com.example.demo2.service.secure.implement;

import com.example.demo2.dao.secure.interfaces.AuthDao;
import com.example.demo2.model.entity.secure.User;
import com.example.demo2.model.request.secure.LoginRequestDTO;
import com.example.demo2.model.request.secure.RegisterRequestDTO;
import com.example.demo2.service.base.BaseServiceImpl;
import com.example.demo2.service.secure.interfaces.AuthService;
import com.example.demo2.utils.secure.JWTUtils;
import com.example.demo2.utils.secure.PBKDF2Encoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 */
@Service
public class AuthServiceImpl extends BaseServiceImpl implements AuthService {

    /**
     *
     */
    private final AuthDao authDao;
    private final JWTUtils jwtUtils;
    private final PBKDF2Encoder passwordEncoder;

    /**
     * @param authDao
     * @param jwtUtils
     * @param passwordEncoder
     */
    public AuthServiceImpl(final AuthDao authDao, final JWTUtils jwtUtils, final PBKDF2Encoder passwordEncoder) {
        this.authDao = authDao;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @param loginRequestDTO
     * @param response
     * @return
     */
    public Mono<ResponseEntity<?>> auth(LoginRequestDTO loginRequestDTO, ServerHttpResponse response) {
        try {
            return this.authDao.findByUsername(loginRequestDTO.getUsername()).map((userDetails) -> {
                if (passwordEncoder.encode(loginRequestDTO.getPassword()).equals(userDetails.getPassword())) {
                    response.getHeaders().add("Authorization", jwtUtils.generateToken(userDetails));
                    return this.okHandler("Token Generado con exito.");
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                }
            });
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * @param registerRequestDTO
     * @return
     */
    public Mono<ResponseEntity<?>> register(RegisterRequestDTO registerRequestDTO) {
        try {
            User user = User.builder()
                    .username(registerRequestDTO.getUsername())
                    .password(this.passwordEncoder.encode(registerRequestDTO.getPassword()))
                    .roles(registerRequestDTO.getRoles())
                    .build();
            Mono<User> userMono = this.authDao.insert(user);
            User userResult = userMono.toProcessor().block();
            return this.okMonoHandler(userMono);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }


}
