package com.sanjay.springmysql;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sanjay.springmysql.repository")
@SpringBootApplication
public class SpringMysqlApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}

}
