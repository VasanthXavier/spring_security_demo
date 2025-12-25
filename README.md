# Spring Security JWT Demo

This project demonstrates a **Spring Boot application secured using Spring Security and JWT (JSON Web Token)**.
It focuses on authentication, authorization, custom security filters, JWT validation, and secured REST APIs using a clean and extensible architecture.

This repository is intended for:
- Backend / Full Stack interview preparation
- Learning Spring Security internals
- Understanding JWT-based authentication
- Building a base for production-ready security

---

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Maven

---

## Project Overview

This application demonstrates:
- Stateless authentication using JWT
- Custom authentication and authorization filters
- Database-backed user authentication
- Spring Security filter chain configuration
- Custom error handling for authentication failures
- Clear separation of concerns (controller, service, security)

---

## High-Level Authentication Flow

1. Client sends username and password to authentication API
2. Spring Security authenticates credentials
3. JWT token is generated on successful authentication
4. Client sends JWT token in Authorization header
5. JWT filter validates token and sets SecurityContext
6. Secured controllers are accessed only if the token is valid

---

## Application Architecture

Client  
→ Authentication Controller  
→ Spring Security Filter Chain  
→ Custom Authentication Filter  
→ JWT Generation  
→ JWT Validation Filter  
→ Secured Controllers

---

## Prerequisites

- Java 8 or above
- Maven
- IDE (IntelliJ / Eclipse / VS Code)
- Postman or curl

---

## How to Run the Application

### Clone the repository
```
git clone https://github.com/VasanthXavier/spring_security_demo.git
cd spring_security_demo
```

### Build and run
```
mvn clean install
mvn spring-boot:run
```

Application runs on:
```
http://localhost:8080
```

---

## Application Entry Point

The application is bootstrapped using the Spring Boot entry point:

**SpringSecurityDemoApplication**

This class initializes the Spring context and starts the embedded server.

---

## Application Configuration

Configuration is managed using `application.properties`.

Typical configurations include:
- Server port
- JWT secret and expiration
- Database configuration (if enabled)

Example:
```
server.port=8080
jwt.secret=******
jwt.expiration=******
```

**Note:**  
Sensitive values such as JWT secrets should be externalized using environment variables in production environments.

---

## Maven Dependencies

Key dependencies used in this project:
- spring-boot-starter-web
- spring-boot-starter-security
- spring-boot-starter-data-jpa
- jjwt (JSON Web Token)
- lombok

Dependency management is handled by Spring Boot.

---

## Security Configuration

- Security is configured using `SecurityFilterChain`
- Stateless authentication (no HTTP session)
- Custom authentication filter for login
- JWT validation filter for secured APIs
- CSRF disabled (API-based application)

### Key Security Components
- SecurityConfig
- SeverAuthenticationFilter
- JwtFilter
- JwtService

---

## Authentication Mechanism

- Authentication is JWT-based
- Credentials are validated using `MyUserDetailsService`
- Users are loaded from database via `UserRepo`
- JWT token is generated after successful authentication
- JWT token is validated on every secured request

Authorization header format:
```
Authorization: Bearer <JWT_TOKEN>
```

---

## API Documentation

### Base URL
```
http://localhost:8080
```

---

## 1. Public API

### GET /about

Authentication: **Not Required**

Description:  
Public endpoint to verify application availability.

Sample Request:
```
curl http://localhost:8080/about
```

Sample Response:
```
Welcome to Spring Security Demo
```

---

## 2. Authentication API

### POST /authenticate

Authentication: **Not Required**

Description:  
Authenticates user credentials and generates a JWT token.

Request Payload:
```json
{
  "username": "user",
  "password": "password"
}
```

Sample Request:
```
curl -X POST http://localhost:8080/authenticate \
-H "Content-Type: application/json" \
-d '{"username":"user","password":"password"}'
```

Successful Response:
```
<JWT_TOKEN>
```

---

## 3. Secured API

### GET /users

Authentication: **Required (JWT)**

Description:  
Returns list of users.
Accessible only with a valid JWT token.

Required Header:
```
Authorization: Bearer <JWT_TOKEN>
```

---

## Error Handling

- Custom error response using `ErrorResponse`
- Authentication failures return structured JSON
- Invalid or expired tokens return HTTP 401
- Unauthorized access returns HTTP 403

---

## HTTP Status Codes

- 200 – Success
- 400 – Bad Request
- 401 – Unauthorized
- 403 – Forbidden

---

## License

Open-source project for learning and demonstration purposes.
