package com.licon.security.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 11:16
 */
public class SecurityUtils {

	public static String getAuthentication(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated()){
			return "";
		}else {
			if(authentication.getPrincipal() instanceof User){
				User u = (User)authentication.getPrincipal();
				return u.getUsername();
			}else {
				return authentication.getPrincipal().toString();
			}
		}
	}
}
