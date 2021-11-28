package com.zaqueurodrigues.esmetrology.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private Environment env;

	@Autowired
	private JwtTokenStore tokenStore;

	public static final String[] PUBLIC = { "/oauth/token", "/h2-console/**" };

	public static final String[] ADMIN = { "/certificates/**", "departments/**", "/instruments/**", "/labs/**",
			"/users/**" };

	public static final String[] NORMAL = { "/certificates/**", "/instruments/**" };

	public static final String[] PERMITED_SWAGGER_PATHS = new String[] { "/v2/api-docs", "/webjars/**",
			"/configuration/ui", "/configuration/security", "/swagger-resources", "/swagger-resources/configuration/ui",
			"/swagger-ui.html" };

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		// H2
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}

		http.authorizeRequests().antMatchers(PUBLIC).permitAll().antMatchers(PERMITED_SWAGGER_PATHS).permitAll()
				.antMatchers(HttpMethod.GET, NORMAL).hasRole("NORMAL").antMatchers(ADMIN).hasRole("ADMIN").anyRequest()
				.authenticated();
	}
}
