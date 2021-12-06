package com.licon.security.config;

import java.util.HashSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/2 15:03
 */
@Configuration
public class CustomerAuthenticationProvider implements AuthenticationProvider {
	final CustomerUserDetailService customerUserDetailService;

	final PasswordEncoder passwordEncoder;

	public CustomerAuthenticationProvider(CustomerUserDetailService customerUserDetailService,PasswordEncoder passwordEncoder) {
		this.customerUserDetailService = customerUserDetailService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String)authentication.getCredentials();

		UserDetails userDetails = customerUserDetailService.loadUserByUsername(username);
		if (userDetails == null){
			throw new UsernameNotFoundException("用户不存在");
		}

		if (!passwordEncoder.matches(password, userDetails.getPassword())){
			throw new BadCredentialsException("密码不正确！");
		}
		return new UsernamePasswordAuthenticationToken(username,password, new HashSet<>(userDetails.getAuthorities()));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
