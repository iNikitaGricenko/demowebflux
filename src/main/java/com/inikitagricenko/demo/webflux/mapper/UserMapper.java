package com.inikitagricenko.demo.webflux.mapper;

import com.inikitagricenko.demo.webflux.dto.UserRegistration;
import com.inikitagricenko.demo.webflux.dto.UserResponse;
import com.inikitagricenko.demo.webflux.entity.UserEntity;
import com.inikitagricenko.demo.webflux.dto.UserLogin;
import com.inikitagricenko.demo.webflux.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
	UserEntity toEntity(User user);

	List<UserEntity> toEntity(List<User> user);

	User toUser(UserEntity userEntity);

	List<User> toUser(List<UserEntity> userEntity);

	User toUser(UserRegistration userRegistration);

	User toUser(UserResponse userResponse);

	UserResponse toResponse(User userEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	UserEntity partialUpdate(User user, @MappingTarget UserEntity userEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	User partialUpdate(User user, @MappingTarget User userEntity);

	UserEntity toEntity(UserLogin userLogin);

	UserLogin toDto(UserEntity userEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	UserEntity partialUpdate(UserLogin userLogin, @MappingTarget UserEntity userEntity);
}