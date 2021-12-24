package com.licon.security.config;

import javax.sql.DataSource;

import com.licon.admin.core.sys.repository.AuthorityRepository;
import com.licon.admin.core.sys.repository.ResourceAuthorityRepository;
import com.licon.admin.core.sys.repository.ResourceRepository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/22 17:16
 */
@Configuration
@Import(PasswordConfig.class)
public class SecurityAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public SecurityConfig securityConfig(CustomerAuthenticationProvider customerAuthenticationProvider,
			CustomerUserDetailService customerUserDetailService, DataSource dataSource,
			CustomerMetadataSource customerMetadataSource){
		return new SecurityConfig(customerAuthenticationProvider,customerUserDetailService,dataSource,customerMetadataSource);
	}

	@Bean
	@ConditionalOnMissingBean
	public CustomerAuthenticationProvider authenticationProvider(CustomerUserDetailService customerUserDetailService, PasswordEncoder passwordEncoder){
		return new CustomerAuthenticationProvider(customerUserDetailService,passwordEncoder);
	}

	@Bean
	@ConditionalOnMissingBean
	public CustomerUserDetailService userDetailService(){
		return new CustomerUserDetailService();
	}

	@Bean
	@ConditionalOnMissingBean
	public CustomerMetadataSource metadataSource(ResourceRepository resourceRepository,
			ResourceAuthorityRepository resourceAuthorityRepository,
			AuthorityRepository authorityRepository){
		return new CustomerMetadataSource(resourceRepository, resourceAuthorityRepository, authorityRepository);
	}

	@Bean
	@Primary
	public CustomerMetaObjectHandler metaObjectHandler(){
		return new CustomerMetaObjectHandler();
	}
}
