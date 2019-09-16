# springBootJPA.GlobalExceptionHandling
This project learn you how to how to connect with JPA and Handling global Exception with YAML configuration
# Below are the yaml configuration for datasource and jpa
spring:
  com:
    sanjay:
      springmysql:
        controller: true
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
name: springJPA-YAML
server:
  port: 8082
