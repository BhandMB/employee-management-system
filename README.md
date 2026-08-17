# Employee Management System

A full-stack employee management application built with **Java 17, Spring Boot, Spring Data JPA, MySQL, REST APIs, and a Bootstrap frontend**.

## Why this project matters

This project demonstrates a practical backend-to-frontend workflow:

- RESTful employee APIs
- Layered Controller → Service → Repository architecture
- Spring Data JPA persistence
- MySQL integration
- Bootstrap web UI
- CRUD operations
- JUnit 5 + Mockito + MockMvc tests
- Environment-based database configuration

## Architecture

![Architecture](docs/architecture.svg)

```text
Browser
   │
   ▼
Bootstrap / JavaScript UI
   │ HTTP / JSON
   ▼
Spring Boot REST Controller
   │
   ▼
Service Layer
   │
   ▼
Spring Data JPA Repository
   │
   ▼
MySQL
```

## Features

- View all employees
- Add employees
- Delete employees
- REST endpoints under `/employees`
- Browser-based employee dashboard
- Automated unit/controller tests

## Tech Stack

| Area | Technology |
|---|---|
| Language | Java 17 |
| Backend | Spring Boot 4.1.0 |
| API | Spring Web / REST |
| Persistence | Spring Data JPA / Hibernate |
| Database | MySQL |
| Frontend | HTML, CSS, JavaScript, Bootstrap 5 |
| Testing | JUnit 5, Mockito, MockMvc |
| Build | Maven |

## Run locally

### Prerequisites

- JDK 17+
- Maven 3.9+
- MySQL 8+

Create the database:

```sql
CREATE DATABASE emsdb;
```

Set environment variables:

```text
DB_URL=jdbc:mysql://localhost:3306/emsdb
DB_USERNAME=root
DB_PASSWORD=your_password
```

Then:

```bash
mvn clean test
mvn spring-boot:run
```

Open:

```text
http://localhost:8080/
```

## API

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/employees` | List employees |
| POST | `/employees` | Create employee |
| DELETE | `/employees/{id}` | Delete employee |

Example:

```json
{
  "name": "Mayur Bhand",
  "department": "Engineering",
  "email": "mayur@example.com",
  "salary": 65000
}
```

## Testing

Run:

```bash
mvn test
```

The repository includes controller tests using MockMvc, service tests using Mockito, and model tests.

## Security note

Database credentials are supplied through environment variables. Do not commit passwords or `.env` files.

## Future improvements

- Employee update endpoint
- Pagination and search
- DTOs and Bean Validation
- Global exception handling
- Authentication and role-based access
- Docker Compose for MySQL
- GitHub Actions CI
