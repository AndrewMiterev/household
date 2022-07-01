package com.example.backend.domain.bo;

import com.example.backend.domain.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserBo {
    @Email
    @NotNull
    private String email;
    private boolean confirmed;
    private String name;
    @NotBlank
    private String password;
    private LocalDateTime registered;
    private LocalDateTime lastLogin;
    private Role role;
    private Long family;
}
