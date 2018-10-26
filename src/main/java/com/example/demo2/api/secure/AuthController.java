package com.example.demo2.api.secure;

import com.example.demo2.model.request.secure.LoginRequestDTO;
import com.example.demo2.service.secure.interfaces.AuthService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/")
public class AuthController {

    private final AuthService authService;

    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "auth", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<ResponseEntity<?>> login(@RequestBody LoginRequestDTO loginRequestDTO, ServerHttpResponse response) {
        return this.authService.auth(loginRequestDTO, response);
    }
}
