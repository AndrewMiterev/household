package com.example.backend.services;

import com.example.backend.domain.entities.Family;

import java.util.List;
import java.util.Optional;

public interface FamilyService {
	void add(Family family);
	void remove(long id);
	Optional<Family> getFamily(long id);
	List<Family> getAll();
	void update(Family family);
}
