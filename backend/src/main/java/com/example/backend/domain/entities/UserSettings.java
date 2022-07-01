package com.example.backend.domain.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSettings {
	private String lastScreen;
	private Long startTimeout;
	private Long endTimeout;
	private String interfaceLanguage;
}
