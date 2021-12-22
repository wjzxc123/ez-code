package com.lut.admin.core.config;

import com.lut.admin.core.sys.mapper.ResourceMapper;
import com.lut.admin.core.sys.repository.ResourceRepository;
import com.lut.admin.core.sys.repository.impl.ResourceRepositoryImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 14:36
 */
@Configuration
@MapperScan("com.lut.admin.core.sys.mapper")
public class RepositoryForeignConfig {
	public RepositoryForeignConfig() {
		System.out.println("");
	}


	@Bean
	public ResourceRepository resourceRepository(ResourceMapper resourceMapper){
		return new ResourceRepositoryImpl(resourceMapper);
	}
}
