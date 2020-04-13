/**
 * 
 */
package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author User
 *
 */

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.authorizeRequests().antMatchers("**/private/**").authenticated().anyRequest().permitAll().and().formLogin()
//				.permitAll();
		http.authorizeRequests().antMatchers("**/public/**").permitAll().antMatchers("**/private/**").authenticated()
				.antMatchers("**/welcome/**").authenticated().antMatchers("/").permitAll().and().formLogin()
				.loginPage("/login").passwordParameter("password").usernameParameter("username")
				.defaultSuccessUrl("/welcome")
				.and()
				.logout().logoutSuccessUrl("/logout");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncode = new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}

		};

		return passwordEncode;
	}

}
