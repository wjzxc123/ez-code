package com.licon.security.config;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.licon.admin.core.sys.po.Resource;
import com.licon.admin.core.sys.repository.AuthorityRepository;
import com.licon.admin.core.sys.repository.ResourceAuthorityRepository;
import com.licon.admin.core.sys.repository.ResourceRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/17 10:27
 */
@Slf4j
public class CustomerMetadataSource implements FilterInvocationSecurityMetadataSource {
	final ResourceRepository resourceRepository;
	final ResourceAuthorityRepository resourceAuthorityRepository;
	final AuthorityRepository authorityRepository;
	public CustomerMetadataSource(ResourceRepository resourceRepository, ResourceAuthorityRepository resourceAuthorityRepository, AuthorityRepository authorityRepository) {
		this.resourceRepository = resourceRepository;
		this.resourceAuthorityRepository = resourceAuthorityRepository;
		this.authorityRepository = authorityRepository;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		HttpServletRequest request = ((FilterInvocation) object).getRequest();
		try {
			List<Resource> inResourcePath = resourceRepository.findInResourcePath(request.getRequestURI());
			System.out.println(inResourcePath);
		}catch (Exception e) {
			log.error("获取权限失败:{}",e.getMessage());
		}

		return SecurityConfig.createList();
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}
}
