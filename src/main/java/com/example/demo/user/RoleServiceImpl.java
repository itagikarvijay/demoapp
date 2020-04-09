/**
 * 
 */
package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repo.RoleRepo;

/**
 * @author User
 *
 */
@Service
@Qualifier("roleServiceImpl")
public class RoleServiceImpl implements IRole {
	
	@Autowired
	RoleRepo roleRepo;

	@Override
	public void addAllRole(List<Role> entities) {
		roleRepo.saveAll(entities);
	}

}
