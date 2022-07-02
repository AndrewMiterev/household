package com.example.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SocialResponseDTO {
    String name;
    String email;
    String provider;
}
