package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@PreAuthorize("hasAnyRole('USER')")
	@RequestMapping("/welcome")
	public String getLoginMessage() {
		System.out.println("Welcome");
		return "welcome";
	}

	@RequestMapping("/login")
	public String login(String error) {
	
		return "login";
	}

	@RequestMapping("/public")
	public String getPublicMessage() {
		return "Public message";
	}

	@PreAuthorize("hasAnyRole('USER')")
	@RequestMapping("/private")
	public String getPrivateMessage() {
		return "Private message";
	}

}
