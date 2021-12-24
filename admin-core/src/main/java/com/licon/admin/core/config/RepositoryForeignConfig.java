package com.licon.admin.core.config;

import com.licon.admin.core.sys.mapper.AuthorityMapper;
import com.licon.admin.core.sys.mapper.ResourceAuthorityMapper;
import com.licon.admin.core.sys.mapper.ResourceMapper;
import com.licon.admin.core.sys.repository.AuthorityRepository;
import com.licon.admin.core.sys.repository.ResourceAuthorityRepository;
import com.licon.admin.core.sys.repository.ResourceRepository;
import com.licon.admin.core.sys.repository.impl.AuthorityRepositoryImpl;
import com.licon.admin.core.sys.repository.impl.ResourceAuthorityRepositoryImpl;
import com.licon.admin.core.sys.repository.impl.ResourceRepositoryImpl;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 14:36
 */
@Configuration
@MapperForeignConfig
public class RepositoryForeignConfig {

	@Bean
	@ConditionalOnMissingBean
	public ResourceRepository resourceRepository(ResourceMapper resourceMapper){
		return new ResourceRepositoryImpl(resourceMapper);
	}

	@Bean
	@ConditionalOnMissingBean
	public ResourceAuthorityRepository resourceAuthorityRepository(ResourceAuthorityMapper resourceAuthorityMapper){
		return new ResourceAuthorityRepositoryImpl(resourceAuthorityMapper);
	}

	@Bean
	@ConditionalOnMissingBean
	public AuthorityRepository authorityRepository(AuthorityMapper authorityMapper){
		return new AuthorityRepositoryImpl(authorityMapper);
	}
}
