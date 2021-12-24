package com.licon.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

import java.io.PrintWriter;
import java.util.Collections;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/2 15:08
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	final CustomerAuthenticationProvider customerAuthenticationProvider;
	final CustomerUserDetailService customerUserDetailService;
	final DataSource dataSource;
	final CustomerMetadataSource customerMetadataSource;


	public SecurityConfig(CustomerAuthenticationProvider customerAuthenticationProvider,
			CustomerUserDetailService customerUserDetailService, DataSource dataSource,
			CustomerMetadataSource customerMetadataSource) {
		this.customerAuthenticationProvider = customerAuthenticationProvider;
		this.customerUserDetailService = customerUserDetailService;
		this.dataSource = dataSource;
		this.customerMetadataSource = customerMetadataSource;
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
		        .anyRequest().authenticated()
				.withObjectPostProcessor(filterSecurityInterceptorObjectPostProcessor());
                //.anyRequest().hasIpAddress("127.0.0.1");IP限制
				//.anyRequest().hasAnyAuthority("ROLE_ADMINS");
                //.anyRequest().access("hasAnyAuthority('ROLE_ADMIN')");
				//自定义授权 不能设置投票策略
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

		http.csrf().disable();
	}

	ObjectPostProcessor<FilterSecurityInterceptor> filterSecurityInterceptorObjectPostProcessor(){
		return new ObjectPostProcessor<FilterSecurityInterceptor>() {
			@Override
			public <O extends FilterSecurityInterceptor> O postProcess(O object) {
				object.setAccessDecisionManager(obtainAccessDecisionManager());
				object.setSecurityMetadataSource(customerMetadataSource);
				return object;
			}
		};
	}

	AccessDecisionManager obtainAccessDecisionManager(){
		return new AffirmativeBased(Collections.singletonList(new RoleHierarchyVoter(new RoleHierarchyImpl())));
	}


	public PersistentTokenRepository persistentTokenRepository(){
		JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
		jdbcTokenRepository.setDataSource(dataSource);
		//jdbcTokenRepository.setCreateTableOnStartup(true);
		return jdbcTokenRepository;
		/*return new InMemoryTokenRepositoryImpl();*/
	}
}
