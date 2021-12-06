package com.licon.security.config;

import com.licon.security.config.CustomerAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
		web.ignoring()
				.antMatchers("/resources/**","/api/*");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/**")
				.permitAll().anyRequest()
				.hasAnyAuthority("ROLE_ADMIN").and()
				.formLogin()
				.permitAll();
	}
}
