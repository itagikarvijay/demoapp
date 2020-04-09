/**
 * 
 */
package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserRole;
import com.example.demo.repo.UserRoleRepo;

/**
 * @author User
 *
 */
@Service
@Qualifier("roleServiceImpl")
public class UserRoleServiceImpl implements IUserRole {
	
	@Autowired
	UserRoleRepo userRoleRepo;

	@Override
	public void addAllUserRole(List<UserRole> entities) {
		userRoleRepo.saveAll(entities);
	}

}
