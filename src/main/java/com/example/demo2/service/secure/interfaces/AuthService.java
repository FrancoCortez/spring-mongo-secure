package com.example.demo2.service.secure.interfaces;

import com.example.demo2.model.request.secure.LoginRequestDTO;
import com.example.demo2.service.base.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;


public interface AuthService extends BaseService {

    public Mono<ResponseEntity<?>> auth(LoginRequestDTO loginRequestDTO, ServerHttpResponse response);
}
