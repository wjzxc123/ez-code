package com.licon.security;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/6 14:04
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
@MapperScan("com.licon.admin.core.sys.mapper")
public class SecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
}
