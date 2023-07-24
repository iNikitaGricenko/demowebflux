package com.inikitagricenko.demo.webflux.adapter;

import com.inikitagricenko.demo.webflux.model.User;

public interface UserInput {

	long save(User user);

	User update(long id, User user);

	long setOnline(User user);

	long setOnline(long id);

	long setOnline(String email);

}
