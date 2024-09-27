# fiap-hc-doctor-api

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tech-challenge-fiap-5soat_fiap-hc-doctor-api&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=tech-challenge-fiap-5soat_fiap-hc-doctor-api)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tech-challenge-fiap-5soat_fiap-hc-doctor-api&metric=coverage)](https://sonarcloud.io/summary/new_code?id=tech-challenge-fiap-5soat_fiap-hc-doctor-api)

The doctor api is responsible for creating doctor profiles, creating their credentials to use the appointment scheduling ecosystem, and creating schedules with the available times for scheduling each doctor.

This service is responsible for

- Create doctor
- Create doctor Schedules
- List available doctor schedules
- Create authorization token with role doctor


----
### Architecture

![hackathon drawio](https://github.com/user-attachments/assets/4a0aee84-0454-46f7-b77d-5417feb23015)

## Technology stack

This API was built using [Java](https://www.java.com/) and several tools:
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for creating stand-alone, production-grade Spring-based Applications
- [Maven](https://maven.apache.org/) - Dependency management and build automation tool
- [PostgreSQL](https://www.postgresql.org/) - Open-source relational database
- [Springdoc OpenAPI UI](https://springdoc.org/) - API documentation tool for Spring Boot projects
- [JUnit](https://junit.org/junit5/) - Testing framework for Java
- [Mockito](https://site.mockito.org/) - Mocking framework for unit tests
- [MapStruct](https://mapstruct.org/) - Code generator for bean mappings
- [Jackson](https://github.com/FasterXML/jackson) - JSON parser for Java
- [Amazon Cognito](https://aws.amazon.com/cognito/) - Access user management
- [Feign](https://github.com/OpenFeign/feign) - Java to HTTP client binder
- [Spring Security](https://spring.io/projects/spring-security) - Powerful and highly customizable security framework
- [Lombok](https://projectlombok.org/) - Library to reduce boilerplate code
- [Docker](https://www.docker.com/) - Platform for developing, shipping, and running applications in containers 
------
