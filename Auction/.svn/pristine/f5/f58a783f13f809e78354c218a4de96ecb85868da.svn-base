package com.dxc.auction.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dxc.auction.domain.user.UserService;

/**
 * Class for Spring Security configuration.
 * @author gdimitrov5
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userService).passwordEncoder(getBCryptPasswordEncoder());
	}


	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/register", "/login", "/register-or-login", "/css/**", "/save-user")
				.permitAll().anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll()
				.usernameParameter("username").passwordParameter("password")
				.and().csrf().disable();
	}


	/**
	 * Method to Crypt Password.
	 * @returnBCryptPasswordEncoder()
	 */
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
