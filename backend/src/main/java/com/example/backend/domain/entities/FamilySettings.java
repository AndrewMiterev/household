package com.example.backend.domain.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FamilySettings {
	private String databaseUri;

	private String storageUri;
	private String userName;
	private String password;

	private String inFolder;
	private String duplicateFolder;
	private String processingFolder;
	private String manualFolder;
	private String permanentFolder;
	private String corruptedFolder;
	private String unprocessedFolder;

	private String geoCoderLicense;
	private String geoCoderLanguage;
}
