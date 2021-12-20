package com.licon.security.config;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.lut.admin.core.mapper.ResourceMapper;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/17 10:27
 */
@Component
public class CustomerMetadataSource implements FilterInvocationSecurityMetadataSource {
	final ResourceMapper resourceMapper;

	public CustomerMetadataSource(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		HttpServletRequest request = ((FilterInvocation) object).getRequest();

		return null;
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
