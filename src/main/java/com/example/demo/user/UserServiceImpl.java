/**
 * 
 */
package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

/**
 * @author User
 *
 */
@Service
@Qualifier("userServiceImpl")
public class UserServiceImpl implements IUser {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public Optional<User> findUserById(Integer Id) {
		return null;
	}

	@Override
	public void addAllUser(List<User> entities) {
		userRepo.saveAll(entities);
	}

}
