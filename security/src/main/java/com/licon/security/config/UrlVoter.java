package com.licon.security.config;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/27 10:09
 */
public class UrlVoter implements AccessDecisionVoter<Object> {
	private final static String ROLE_PREFIX = "ROLE_";
	@Override
	public boolean supports(ConfigAttribute attribute) {
		String authority = attribute.getAttribute();
		return StringUtils.hasLength(authority) && !authority.startsWith(ROLE_PREFIX);
	}

	@Override
	public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
		if (authentication == null){
			return ACCESS_DENIED;
		}

		int result = ACCESS_DENIED;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (ConfigAttribute attribute : attributes) {
			if (this.supports(attribute)){
				for (GrantedAuthority authority : authorities) {
					if (attribute.getAttribute().equals(authority.getAuthority())) {
						return ACCESS_GRANTED;
					}
				}
			}
		}
		return result;
	}

	@Override
	public boolean supports(Class clazz) {
		return true;
	}
}
