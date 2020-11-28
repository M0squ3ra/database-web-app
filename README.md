# Database Web App
Spring Boot based version of database web app from developed in the course Spring &amp; Hibernate for Beginners by Chad Darby
The web app uses Postgres, here is a tutorial to connect Postgresql and spring boot https://developer.okta.com/blog/2019/02/20/spring-boot-with-postgresql-flyway-jsonb

application.properties (i didn't include it in the project for security):


```
spring.mvc.view.prefix: /WEB-INF/jsp/
spring.mvc.view.suffix: .jsp

## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:postgresql://localhost:5432/DBNAME
spring.datasource.username=yourPostgresUser
spring.datasource.password=yourPostgresPassword
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```

Updates:
 - Added simple Log information for Create, Update and Delete