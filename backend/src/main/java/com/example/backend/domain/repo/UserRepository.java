package com.example.backend.domain.repo;

import com.example.backend.domain.entities.Role;
import com.example.backend.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
	List<User> findByRole(Role role);
}
