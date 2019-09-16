# springBootJPA.GlobalExceptionHandling
This project learn you how to how to connect with JPA and Handling global Exception with YAML configuration
## Below are the yaml configuration for datasource and jpa
```yaml
spring:
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/myschema
    username: root
    password: root
  jpa:
    #hibernate.ddl-auto: update
    generate-ddl: true
    show-sql: true
    hibernate.naming.physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```
## Main method configuration
```java
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
```

