package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

public interface IUser {

	Optional<User> findUserById(Integer Id);
	void addAllUser(List<User> entities);
}
