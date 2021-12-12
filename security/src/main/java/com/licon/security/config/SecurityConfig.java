package com.licon.security.config;

import com.licon.security.config.CustomerAuthenticationProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/2 15:08
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public final CustomerAuthenticationProvider customerAuthenticationProvider;
	public final CustomerUserDetailService customerUserDetailService;
	public SecurityConfig(CustomerAuthenticationProvider customerAuthenticationProvider, CustomerUserDetailService customerUserDetailService) {
		this.customerAuthenticationProvider = customerAuthenticationProvider;
		this.customerUserDetailService = customerUserDetailService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customerAuthenticationProvider);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin()
				.loginPage("/login.html")
				.usernameParameter("uname")
				.passwordParameter("pwd")
				.loginProcessingUrl("/login")
				.successForwardUrl("/main")
				/*.successHandler((request, response, authentication) -> {
					System.out.println(authentication.getPrincipal());
					System.out.println(authentication.getAuthorities());
					response.sendRedirect("/main.html");
				})*/
				//.failureForwardUrl("/toError")
				.failureHandler((request, response, exception) -> {
					System.out.println(exception.getMessage());
					response.sendRedirect("/error.html");
				});

		http.exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                   response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write("{\"message\":\"权限不足!\"}");
                    writer.flush();
                    writer.close();
                });

		http.rememberMe()
				.tokenRepository(persistentTokenRepository())
				//.rememberMeParameter()
				.userDetailsService(customerUserDetailService)
				.tokenValiditySeconds(60);

		http.authorizeRequests().antMatchers("/api/**","/login.html","/error.html")
                //.permitAll()
                .access("permitAll()")
		        .anyRequest().authenticated();
                //.anyRequest().hasIpAddress("127.0.0.1");IP限制
				//.anyRequest().hasAnyAuthority("ROLE_ADMINS");
                //.anyRequest().access("hasAnyAuthority('ROLE_ADMIN')");
				//自定义授权
				//.anyRequest().access("@customerURLSecurity.hasPermission(request,authentication)");

		http.logout()
				.logoutUrl("/logout")
				.logoutSuccessHandler((request, response, authentication) -> {
					response.setContentType("application/json;charset=utf-8");
					PrintWriter writer = response.getWriter();
					writer.write("{\"message\":\"退出成功!\"}");
					writer.flush();
					writer.close();
				});

		//http.csrf().disable();
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository(){
		return new InMemoryTokenRepositoryImpl();
	}
}
