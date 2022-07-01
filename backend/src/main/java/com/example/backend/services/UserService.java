package com.example.backend.services;

import com.example.backend.domain.bo.UserBo;

import java.util.List;
import java.util.Optional;

public interface UserService {
	void updateLoginTime(String email);
	void registerUser(UserBo user);
	void removeUser(String email);
	Optional<UserBo> getUserInfo(String email);
	List<UserBo> getAll();
	UserBo getCurrentPrincipal();
	void updateUser(UserBo user);
}
