package com.licon.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Component
public class CustomerURLSecurity {
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetailsService){

        }
        if (principal instanceof String){
            if ("admin".equalsIgnoreCase(principal.toString())){
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMINS"))){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }
}
