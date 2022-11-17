package com.zaqueurodrigues.esmetrology.config;

import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${security.oauth2.client.client-id}")
	private String clientId;

	@Value("${security.oauth2.client.client-secret}")
	private String clientSecret;

	@Bean
	public Docket esmetrology() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.zaqueurodrigues")).paths((mountPredicates())).build()
				.apiInfo(ApiInfo()).securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Collections.singletonList(securitySchema()));

	}

	private ApiInfo ApiInfo() {
		return new ApiInfoBuilder().title("ESMetrology").description("Project for tcc").license("")
				.licenseUrl("http://unlincense.org").termsOfServiceUrl("").version("1.0.0")
				.contact(new Contact("Zaqueu Rodrigues", "", "zakeurodrigues@outlook.com")).build();
	}

	private Predicate<String> mountPredicates() {
		final List<String> permited = concat(of(ResourceServerConfig.ADMIN), of(ResourceServerConfig.STANDARD))
				.collect(toList());
		final Stream<String> concat = concat(of(ResourceServerConfig.PUBLIC), permited.stream());
		List<Predicate<String>> all = concat.map(PathSelectors::ant).collect(toList());
		return or(all);
	}

	private Predicate<String> mountPredicates(Predicate<String> mainPath) {
		List<Predicate<String>> predicates = of(ResourceServerConfig.PUBLIC).map(PathSelectors::ant).collect(toList());
		Predicate<String> notInList = not(or(predicates));
		return and(mainPath, notInList);
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().forPaths(mountPredicates(PathSelectors.ant("/**")))
				.securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {

		final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
		authorizationScopes[0] = new AuthorizationScope("read", "read all");
		authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
		authorizationScopes[2] = new AuthorizationScope("write", "write all");

		return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));
	}

	private OAuth securitySchema() {

		List<AuthorizationScope> authorizationScopeList = new ArrayList<>();
		authorizationScopeList.add(new AuthorizationScope("read", "read all"));
		authorizationScopeList.add(new AuthorizationScope("trust", "trust all"));
		authorizationScopeList.add(new AuthorizationScope("write", "access all"));

		List<GrantType> grantTypes = new ArrayList<>();
		GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant("/oauth/token");

		grantTypes.add(creGrant);

		return new OAuth("oauth2schema", authorizationScopeList, grantTypes);

	}

	@Bean
	public SecurityConfiguration securityInfo() {
		return new SecurityConfiguration(clientId, clientSecret, "", "", "", ApiKeyVehicle.HEADER, "", " ");
	}

}
