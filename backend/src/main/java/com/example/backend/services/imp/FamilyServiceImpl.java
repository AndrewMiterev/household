package com.example.backend.services.imp;

import com.example.backend.domain.entities.Family;
import com.example.backend.domain.repo.FamilyRepository;
import com.example.backend.services.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService {
	private final FamilyRepository repository;

	@Override
	public void add(Family family) {
		repository.insert(family);
	}

	@Override
	public void remove(long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Family> getFamily(long id) {
		return repository.findById(id);
	}

	@Override
	public List<Family> getAll() {
		return repository.findAll();
	}

	@Override
	public void update(Family family) {
		repository.save(family);
	}
}
