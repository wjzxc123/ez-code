package com.licon.security;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityApplicationTests {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGeneratePassword(){
		String admin = passwordEncoder.encode("admin");
		System.out.println(admin);
	}
}
