package com.inikitagricenko.demo.webflux.persistence;

import com.inikitagricenko.demo.webflux.adapter.UserInput;
import com.inikitagricenko.demo.webflux.adapter.UserOutput;
import com.inikitagricenko.demo.webflux.entity.UserEntity;
import com.inikitagricenko.demo.webflux.mapper.UserMapper;
import com.inikitagricenko.demo.webflux.model.User;
import com.inikitagricenko.demo.webflux.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPersistence implements UserInput, UserOutput {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Override
	public long save(User user) {
		UserEntity entity = userMapper.toEntity(user);
		return userRepository.save(entity).getId();
	}

	@Override
	public User update(long id, User user) {
		UserEntity entity = userRepository.findById(id).get();
		UserEntity updated = userMapper.partialUpdate(user, entity);
		return userMapper.toUser(userRepository.save(updated));
	}

	@Override
	public long setOnline(User user) {
		return 0;
	}

	@Override
	public long setOnline(long id) {
		return 0;
	}

	@Override
	public long setOnline(String email) {
		return 0;
	}

	@Override
	public User get(long id) {
		return userRepository.findById(id)
				.map(userMapper::toUser)
				.orElseThrow();
	}

	@Override
	public User get(String email) {
		return userRepository.findByEmail(email)
				.map(userMapper::toUser)
				.orElseThrow();
	}

	@Override
	public List<User> getAll() {
		return userMapper.toUser(userRepository.findAll());
	}
}
