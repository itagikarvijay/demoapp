package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@PreAuthorize("hasAnyRole('USER')")
	@RequestMapping("/welcome")
	public String getLoginMessage(Principal principal,Authentication authentication,HttpServletRequest request) {
		System.out.println(principal.getName());
		SecurityContext sc = SecurityContextHolder.getContext();
		System.out.print("Printing");
		System.out.print("Printing");
		sc.setAuthentication(authentication);
		
		if(authentication.isAuthenticated()) {

			HttpSession session = request.getSession(true);
			session.setAttribute("USER_SESSION", authentication);
		}
		
		
		System.out.println(principal.getName());


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

	@PreAuthorize("hasAnyRole('USER')")
	@PostMapping("/invalidate")
	public String logout(HttpServletRequest request) {
		System.out.println("Logout.!");
		SecurityContextHolder.getContext().setAuthentication(null);
		
		request.getSession().invalidate();
		request.getSession();
		return "redirect:/welcome";
	}
}
