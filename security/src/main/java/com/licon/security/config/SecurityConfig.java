package com.licon.security.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.AffirmativeBased;
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
	final CustomerSecurityMetadataSource customerMetadataSource;
	final UrlVoter urlVoter;

	public SecurityConfig(CustomerAuthenticationProvider customerAuthenticationProvider,
			CustomerUserDetailService customerUserDetailService, DataSource dataSource,
			CustomerSecurityMetadataSource customerMetadataSource, UrlVoter urlVoter) {
		this.customerAuthenticationProvider = customerAuthenticationProvider;
		this.customerUserDetailService = customerUserDetailService;
		this.dataSource = dataSource;
		this.customerMetadataSource = customerMetadataSource;
		this.urlVoter = urlVoter;
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
				.successHandler((request, response, authentication) -> {
					System.out.println(authentication.getPrincipal());
					System.out.println(authentication.getAuthorities());
					response.sendRedirect("/main.html");
				})
				.failureHandler((request, response, exception) -> {
					System.out.println(exception.getMessage());
					response.sendRedirect("/error.html");
				});

		http.exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                   response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write("{\"message\":\"????????????!\"}");
                    writer.flush();
                    writer.close();
                });

		http.rememberMe()
				.tokenRepository(persistentTokenRepository())
				//.rememberMeParameter()
				.userDetailsService(customerUserDetailService)
				.tokenValiditySeconds(60);

		http.authorizeRequests().antMatchers("/api/**","/login.html","/error.html")
                .permitAll()
				.anyRequest()
				.authenticated()
				.withObjectPostProcessor(filterSecurityInterceptorObjectPostProcessor())
				.and()
				.csrf()
				.disable();


		http.logout()
				.logoutUrl("/logout")
				.logoutSuccessHandler((request, response, authentication) -> {
					response.setContentType("application/json;charset=utf-8");
					PrintWriter writer = response.getWriter();
					writer.write("{\"message\":\"????????????!\"}");
					writer.flush();
					writer.close();
				});

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
		return new AffirmativeBased(Collections.singletonList(urlVoter));
	}


	public PersistentTokenRepository persistentTokenRepository(){
		JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
		jdbcTokenRepository.setDataSource(dataSource);
		jdbcTokenRepository.setCreateTableOnStartup(false);
		return jdbcTokenRepository;
		/*return new InMemoryTokenRepositoryImpl();*/
	}
}
