package com.example.demo2.model.response.utils;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
public class ErrorHandlerResponse implements Serializable {
    private String msg;
    private Object trace;
    private Object cause;

}
