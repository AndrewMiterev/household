package com.example.backend.domain.repo;

import com.example.backend.domain.entities.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyRepository extends MongoRepository<Family, Long> {
}
