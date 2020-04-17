package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.demo.user.IRole;
import com.example.demo.user.IUser;
import com.example.demo.user.IUserRole;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	IUser user;

	@Autowired
	IRole role;

	@Autowired
	IUserRole userRole;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
//		User u1 = new User();
//		u1.setName("user");
//		u1.setPassword("password");
//		
//		User u2 = new User();
//		u2.setName("admin");
//		u2.setPassword("password");
//		
//		Role r1 = new Role();
//		r1.setRole("USER");
//		
//		Role r2 = new Role();
//		r2.setRole("ADMIN");
//		
//		UserRole ur1 = new UserRole();
//		ur1.setUser(1);
//		ur1.setRole(1);
//		
//		UserRole ur2 = new UserRole();
//		ur2.setUser(2);
//		ur2.setRole(1);
//		
//		UserRole ur3 = new UserRole();
//		ur3.setUser(2);
//		ur3.setRole(2);
//
//		
//		List<User> userList = new ArrayList<User>();
//		userList.add(u1);
//		userList.add(u2);
//		
//		List<Role> roleList = new ArrayList<Role>();
//		roleList.add(r1);
//		roleList.add(r2);
//		
//		List<UserRole> userRoleList = new ArrayList<UserRole>();
//		userRoleList.add(ur1);
//		userRoleList.add(ur2);
//		userRoleList.add(ur3);
//		
//		
//		user.addAllUser(userList);
//		role.addAllRole(roleList);
//		userRole.addAllUserRole(userRoleList);
	}

}
