package com.example.backend.domain.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
public class Family {
	@Id
	private long id;
	private String name;
	@DBRef
	private List<User> users;
	private FamilySettings settings;
}
