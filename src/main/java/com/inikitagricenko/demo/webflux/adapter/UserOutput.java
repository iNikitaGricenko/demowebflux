package com.inikitagricenko.demo.webflux.adapter;

import com.inikitagricenko.demo.webflux.model.User;

import java.util.List;

public interface UserOutput {

	User get(long id);

	User get(String email);

	List<User> getAll();
}
