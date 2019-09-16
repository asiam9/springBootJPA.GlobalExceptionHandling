package com.sanjay.springmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sanjay.springmysql.repository")
@SpringBootApplication
public class SpringMysqlApplication extends SpringBootServletInitializer {
	/*Deployment for server*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringMysqlApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}

}
