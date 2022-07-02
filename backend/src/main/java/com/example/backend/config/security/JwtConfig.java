package com.example.backend.config.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ConfigurationProperties("household.jwt")
@Component
@NoArgsConstructor
@Getter
@Setter
@ToString
@Validated
public class JwtConfig {
    @NotBlank
    @Size(min=40)
    String secret;
    @NotBlank
    String prefix;
    @NotNull
    Integer tokenExpirationInDays;
}
