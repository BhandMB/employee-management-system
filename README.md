# 👥 Employee Management System

[![CI](https://github.com/BhandMB/employee-management-system/actions/workflows/ci.yml/badge.svg)](https://github.com/BhandMB/employee-management-system/actions/workflows/ci.yml)
[![Java 17](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-6DB33F?logo=springboot)](https://spring.io/projects/spring-boot)
[![MySQL 8](https://img.shields.io/badge/MySQL-8-4479A1?logo=mysql&logoColor=white)](https://www.mysql.com/)

A portfolio-ready full-stack Employee Management System built with **Java 17, Spring Boot, Spring Data JPA, MySQL, Spring Security, REST APIs, Bootstrap and JavaScript**. It demonstrates production-oriented backend architecture, database-backed authentication, RBAC, validation, pagination, analytics, OpenAPI documentation, automated tests and Docker deployment.

## ⭐ Features

- 📊 Live dashboard with employee, department and payroll analytics
- 🔎 Search, department filtering, active/inactive filtering and pagination
- ➕ Create and ✏️ update employees
- 🗑️ Admin-only employee deletion
- 🔐 Persistent MySQL users with `ADMIN`, `HR` and `EMPLOYEE` roles
- 🛡️ Method-level role authorization and cookie-based CSRF protection
- 🧱 DTO layer separating API contracts from JPA entities
- ⚠️ Global validation, not-found, conflict and server error handling
- 📚 Swagger UI + OpenAPI JSON
- 🧪 Unit/controller tests plus Spring Boot integration tests with H2
- 🐳 Dockerfile + Docker Compose for app and MySQL
- ❤️ Actuator health/metrics endpoints
- ⚙️ Environment-driven configuration with no committed credentials
- 🚀 Production profile with `validate` schema mode and response compression

## 🏗️ Architecture

```text
Browser / Bootstrap / JavaScript
            │
            ▼
     Spring Security + CSRF
            │
            ▼
       REST Controllers
            │
            ▼
        DTO Contracts
            │
            ▼
       Service Layer
            │
            ▼
 Spring Data JPA Repositories
        │             │
        ▼             ▼
     MySQL        Global Errors

OpenAPI / Swagger ───── REST API
Actuator ────────────── Health & Metrics
```

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Backend | Spring Boot 4.1.0 |
| Security | Spring Security, BCrypt, RBAC, CSRF |
| Persistence | Spring Data JPA / Hibernate |
| Database | MySQL 8+ |
| API | REST + OpenAPI 3 / Swagger UI |
| Validation | Jakarta Bean Validation |
| Frontend | HTML, CSS, JavaScript, Bootstrap 5 |
| Testing | JUnit 5, Mockito, MockMvc, H2 |
| Operations | Actuator, Docker, Docker Compose |
| CI/CD | GitHub Actions |
| Build | Maven |

## 👥 Roles & Permissions

| Capability | ADMIN | HR | EMPLOYEE |
|---|:---:|:---:|:---:|
| View employees | ✅ | ✅ | ✅ |
| Search/filter/paginate | ✅ | ✅ | ✅ |
| Dashboard analytics | ✅ | ✅ | ✅ |
| Create employee | ✅ | ✅ | ❌ |
| Update employee | ✅ | ✅ | ❌ |
| Delete employee | ✅ | ❌ | ❌ |

Users are stored in the `app_users` table and passwords are BCrypt-hashed. Demo users are seeded only when missing.

## 🚀 Local setup

### Prerequisites

- JDK 17+
- Maven 3.9+
- MySQL 8+

Create the database:

```sql
CREATE DATABASE emsdb;
```

PowerShell configuration:

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/emsdb"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_mysql_password"
$env:APP_ADMIN_PASSWORD="change-me"
$env:APP_HR_PASSWORD="change-me"
$env:APP_EMPLOYEE_PASSWORD="change-me"
```

Build, test and run:

```bash
mvn clean test
mvn spring-boot:run
```

Open `http://localhost:8080/`.

### Demo accounts

| Username | Role | Default development password |
|---|---|---|
| admin | ADMIN | admin123 |
| hr | HR | hr123 |
| employee | EMPLOYEE | employee123 |

Change these passwords through environment variables before any shared or production deployment.

## 🐳 Docker Compose

Build the application first, then start both services:

```bash
mvn clean package -DskipTests
docker compose up --build
```

The application will be available on port `8080` and MySQL on `3306`. Compose persists database data in the `mysql_data` volume.

For production, set strong values for `DB_PASSWORD`, `APP_ADMIN_PASSWORD`, `APP_HR_PASSWORD` and `APP_EMPLOYEE_PASSWORD` rather than using defaults.

## ☁️ Production deployment

Use the production profile with a managed MySQL database:

```bash
java -jar target/employee-management-2.0.0.jar --spring.profiles.active=prod
```

Recommended production environment variables:

```text
DB_URL=jdbc:mysql://<host>:3306/emsdb?useSSL=true&serverTimezone=UTC
DB_USERNAME=<database-user>
DB_PASSWORD=<strong-secret>
DDL_AUTO=validate
APP_ADMIN_PASSWORD=<strong-secret>
APP_HR_PASSWORD=<strong-secret>
APP_EMPLOYEE_PASSWORD=<strong-secret>
SERVER_PORT=8080
```

Production configuration intentionally uses `validate` rather than automatically modifying the schema. Apply schema migrations through a migration tool before deploying major database changes.

## 📚 API & Swagger

When running locally:

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
- Health: `http://localhost:8080/actuator/health`

See [`docs/api-examples.md`](docs/api-examples.md) for endpoint examples.

## 🧪 Testing

```bash
mvn test
```

The suite includes controller tests and full Spring Boot integration tests covering CRUD, pagination/search, validation, database persistence and role restrictions. H2 keeps CI tests isolated from a developer's MySQL instance.

## 📁 Project structure

```text
src/main/java/com/example/employeemanagement/
├── config/        # Security, seed data, OpenAPI
├── controller/    # REST/page controllers
├── dto/           # API request/response contracts
├── exception/     # Domain + global API errors
├── model/         # JPA entities and roles
├── repository/    # Database access
└── service/       # Business logic and mapping

src/main/resources/
├── static/        # Dashboard, add/edit UI and JS
├── templates/     # Login page
├── application.properties
└── application-prod.properties

docs/              # API and architecture documentation
Dockerfile
Docker Compose
```

## 📸 Portfolio screenshots

Capture these from the real running application:

1. Login with role-based account
2. Dashboard analytics
3. Search/filter/pagination
4. Add employee form
5. Edit employee
6. Swagger UI
7. MySQL-backed role behavior

## 👨‍💻 Author

**Mayur Bhand**

- GitHub: https://github.com/BhandMB
- LinkedIn: https://www.linkedin.com/in/mayurbhand/
