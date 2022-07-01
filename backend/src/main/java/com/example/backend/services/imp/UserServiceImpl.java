package com.example.backend.services.imp;

import com.example.backend.domain.bo.UserBo;
import com.example.backend.domain.entities.Role;
import com.example.backend.domain.entities.User;
import com.example.backend.domain.repo.UserRepository;
import com.example.backend.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	private final ObjectMapper mapper = new ObjectMapper();

	@PostConstruct
	private void init() {
		List<User> users = userRepository.findByRole(Role.SYSTEM);
		if (users.isEmpty())
			userRepository.save(
					User.builder()
							.email("admin")
							.name("System administrator")
							.password(encoder.encode("admin"))
							.role(Role.SYSTEM)
							.build()
			);
	}

	@Override
	public void updateLoginTime(String email) {
		userRepository.findById(email).ifPresentOrElse(user -> {
			user.setLastLogin(LocalDateTime.now());
			userRepository.save(user);
		}, () -> log.error("User {} doesn't exist", email));
	}

	@Override
	public void registerUser(UserBo user) {
		var userEntity = User.builder()
				.email(user.getEmail())
				.registered(user.getRegistered())
				.role(user.getRole())
				.name(user.getName())
				.password(user.getPassword())
				.confirmed(user.isConfirmed())
				.build();
		userRepository.save(userEntity);
	}

	@Override
	public void removeUser(String email) {
		userRepository.deleteById(email);
	}

	@Override
	public Optional<UserBo> getUserInfo(String email) {
		return userRepository.findById(email).map(user -> mapper.convertValue(user, UserBo.class));
	}

	@Override
	public List<UserBo> getAll() {
		return userRepository.findAll().stream().map(user -> mapper.convertValue(user, UserBo.class)).toList();
	}

	@Override
	public UserBo getCurrentPrincipal() {
		return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
				.filter(Authentication::isAuthenticated)
				.map(Authentication::getPrincipal)
				.map(p -> (p instanceof org.springframework.security.core.userdetails.User user) ? user.getUsername() : (String) p)
				.flatMap(this::getUserInfo)
				.orElse(null);
	}

	@Override
	public void updateUser(UserBo user) {
		var oldEntity = userRepository.findById(user.getEmail()).orElseThrow();
		var newUser = mapper.convertValue(user, User.class);
		if (Objects.isNull(newUser.getPassword())) newUser.setPassword(oldEntity.getPassword());
		userRepository.save(newUser);
	}
}
