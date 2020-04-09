package com.example.demo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
@Qualifier("customUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepo.findByName(username);

		if (username == null) {
			throw new UsernameNotFoundException("User not found.!");
		}

		return new CustomUserDetails(user.get());
	}

	

}
