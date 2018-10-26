package com.example.demo2.model.entity.base;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class BaseEntity implements Serializable {
    private String _id;
}
