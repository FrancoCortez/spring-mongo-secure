package com.example.demo2.model.request.secure;

import com.example.demo2.model.entity.secure.Role;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
public class RegisterRequestDTO implements Serializable {
    private String username;
    private String password;
    private List<Role> roles;
}
