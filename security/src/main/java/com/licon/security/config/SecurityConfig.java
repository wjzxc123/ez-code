package com.licon.security.config;

import com.licon.security.config.CustomerAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/2 15:08
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public final CustomerAuthenticationProvider customerAuthenticationProvider;

	public SecurityConfig(CustomerAuthenticationProvider customerAuthenticationProvider) {
		this.customerAuthenticationProvider = customerAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customerAuthenticationProvider);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin()
				.loginPage("/login.html")
				.usernameParameter("uname")
				.passwordParameter("pwd")
				.loginProcessingUrl("/login")
				//.successForwardUrl("/main")
				.successHandler((request, response, authentication) -> {
					System.out.println(authentication.getPrincipal());
					System.out.println(authentication.getAuthorities());
					response.sendRedirect("http://www.baidu.com");
				})
				//.failureForwardUrl("/toError")
				.failureHandler((request, response, exception) -> {
					System.out.println(exception.getMessage());
					response.sendRedirect("/error.html");
				});


		http.authorizeRequests().antMatchers("/api/**","/login.html","/error.html").permitAll()
				.anyRequest()
				.hasAnyAuthority("ROLE_ADMIN");

		http.csrf().disable();
	}
}
