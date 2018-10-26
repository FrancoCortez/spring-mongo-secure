package com.example.demo2.service.base;

import com.example.demo2.model.response.utils.ErrorHandlerResponse;
import com.example.demo2.model.response.utils.SuccessHandlerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public class BaseServiceImpl implements BaseService {

    protected Mono<ResponseEntity<?>> errorHandler(Exception ex) {
        ErrorHandlerResponse response = ErrorHandlerResponse.builder()
                .msg(ex.getMessage())
                .trace(ex.getStackTrace())
                .cause(ex.getCause())
                .build();
        return Mono.justOrEmpty(ResponseEntity.badRequest().body(response));
    }

    protected Mono<ResponseEntity<?>> errorHandler(String msg) {
        ErrorHandlerResponse response = ErrorHandlerResponse.builder()
                .msg(msg)
                .build();
        return Mono.justOrEmpty(ResponseEntity.badRequest().body(response));
    }

    protected Mono<ResponseEntity<?>> warnnigHandler(String msg) {
        ErrorHandlerResponse response = ErrorHandlerResponse.builder()
                .msg(msg)
                .build();
        return Mono.justOrEmpty(new ResponseEntity<>(response, HttpStatus.CONFLICT));
    }

    protected Mono<ResponseEntity<?>> notFoundHandler(String msg) {
        ErrorHandlerResponse response = ErrorHandlerResponse.builder()
                .msg(msg)
                .build();
        return Mono.justOrEmpty(new ResponseEntity<>(response, HttpStatus.NOT_FOUND));
    }

    protected Mono<ResponseEntity<?>> okMonoHandler(Object data) {
        SuccessHandlerResponse response = SuccessHandlerResponse.builder()
                .data(data)
                .build();
        return Mono.justOrEmpty(ResponseEntity.ok(response));
    }

    protected ResponseEntity<?> okHandler(Object data) {
        SuccessHandlerResponse response = SuccessHandlerResponse.builder()
                .data(data)
                .build();
        return (ResponseEntity.ok(response));
    }
}
