# spring-carpool
The repository contains a sample implementation of some Spring Framework features. Theere is a simple REST API implementation for customer resources supporting CRUD operations. 

There is a very basic Spring Security based authentication. In order to Authenticate the API calls, you can use username: test_user and password: test_password.
The proper datasource connection should alse be set.

The project uses:
- [Spring Boot](http://github.com/spring-projects/spring-boot)
- [Spring Data JPA](http://github.com/spring-projects/spring-data-jpa)
- [Spring Security](http://spring.io/projects/spring-security)
- [Hibernate](https://hibernate.org/)
- [Lombok](http://projectlombok.org)
- [Liquibase](http://www.liquibase.org/)
- [ModelMapper](http://modelmapper.org/)
- [Problem Spring Web](http://github.com/zalando/problem-spring-web)

Futher To Do:
- Setup Development and production profile
- JWT based authentication
- Setup Testcontainers for DAO unit tests
- Logging
- Testing
- Containerized deployment
