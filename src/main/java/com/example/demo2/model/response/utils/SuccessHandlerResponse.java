package com.example.demo2.model.response.utils;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
public class SuccessHandlerResponse implements Serializable {
    private Object data;
}
