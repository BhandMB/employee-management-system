# 👥 Employee Management System

[![CI](https://github.com/BhandMB/employee-management-system/actions/workflows/ci.yml/badge.svg)](https://github.com/BhandMB/employee-management-system/actions/workflows/ci.yml)
[![Java 17](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-6DB33F?logo=springboot)](https://spring.io/projects/spring-boot)
[![MySQL 8](https://img.shields.io/badge/MySQL-8-4479A1?logo=mysql&logoColor=white)](https://www.mysql.com/)

A portfolio-ready **full-stack Employee Management System** built with Java 17 and Spring Boot. It combines a REST API, MySQL persistence, responsive dashboard, validation, authentication, automated tests, and GitHub Actions CI.

## ✨ Highlights

- 📊 Live dashboard: total employees, active employees, departments and active payroll
- 👤 Employee directory with status and salary information
- ➕ Create employees with server-side validation
- 🗑️ Delete employees through a REST API
- 🔐 Spring Security form login with environment-based credentials
- 🗄️ MySQL + Spring Data JPA persistence
- 🧪 JUnit 5, Mockito and MockMvc tests
- ⚙️ Environment-based configuration with no committed secrets
- 🚀 Maven build and GitHub Actions CI
- 📱 Responsive Bootstrap-based frontend

## 🏗️ Architecture

![Architecture](docs/architecture.svg)

```text
┌─────────────────────┐
│ Browser / Bootstrap │
│ HTML + JavaScript   │
└──────────┬──────────┘
           │ HTTP / JSON
           ▼
┌─────────────────────┐
│ Spring Security     │
│ Authentication      │
└──────────┬──────────┘
           ▼
┌─────────────────────┐
│ REST Controller     │
└──────────┬──────────┘
           ▼
┌─────────────────────┐
│ Service Layer       │
└──────────┬──────────┘
           ▼
┌─────────────────────┐
│ Spring Data JPA     │
└──────────┬──────────┘
           ▼
┌─────────────────────┐
│ MySQL 8             │
└─────────────────────┘
```

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Backend | Spring Boot 4.1.0 |
| Web/API | Spring Web, REST |
| Security | Spring Security |
| Persistence | Spring Data JPA / Hibernate |
| Database | MySQL 8+ |
| Validation | Jakarta Bean Validation |
| Frontend | HTML, CSS, JavaScript, Bootstrap 5 |
| Testing | JUnit 5, Mockito, MockMvc |
| Build | Maven |
| CI/CD | GitHub Actions |

## 📁 Project Structure

```text
src/main/java/com/example/employeemanagement/
├── config/             # Security configuration
├── controller/         # REST and page controllers
├── model/              # JPA entities
├── repository/         # Spring Data repositories
└── service/            # Business logic

src/main/resources/
├── static/             # Dashboard, add form and JavaScript
├── templates/          # Login page
├── application.properties
└── application-example.properties

docs/
├── architecture.svg
└── api-examples.md
```

## 🚀 Run Locally

### 1. Prerequisites

- JDK 17+
- Maven 3.9+
- MySQL 8+

### 2. Create the database

```sql
CREATE DATABASE emsdb;
```

### 3. Configure environment variables

Windows PowerShell:

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/emsdb"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_mysql_password"
$env:APP_SECURITY_USERNAME="admin"
$env:APP_SECURITY_PASSWORD="change_this_password"
```

The application has safe development defaults for the login username/password, but **use environment variables for real credentials**.

### 4. Build and test

```bash
mvn clean test
```

### 5. Start the application

```bash
mvn spring-boot:run
```

Open `http://localhost:8080/` and sign in.

## 🔌 REST API

| Method | Endpoint | Description |
|---|---|---|
| GET | `/employees` | List all employees |
| GET | `/employees/stats` | Dashboard statistics |
| POST | `/employees` | Create an employee |
| DELETE | `/employees/{id}` | Delete an employee |

### Example request

```http
POST /employees
Content-Type: application/json
```

```json
{
  "name": "Mayur Bhand",
  "department": "Engineering",
  "email": "mayur@example.com",
  "salary": 65000
}
```

### Dashboard response

```json
{
  "totalEmployees": 10,
  "activeEmployees": 8,
  "departments": 4,
  "payroll": 650000.0
}
```

See [`docs/api-examples.md`](docs/api-examples.md) for additional examples.

## 🔐 Security

Spring Security protects the application behind a login page. The configured account is created in memory from environment variables, while employee API requests require an authenticated session.

**Never commit passwords, `.env` files, API keys or production credentials.**

## 🧪 Testing

The project contains controller, service and model tests. Run them with:

```bash
mvn test
```

GitHub Actions also builds and tests the project on pushes to `main`.

## 📊 Dashboard

The dashboard calculates its values directly from the employee database:

- **Total Employees** → total employee records
- **Active Employees** → employees whose `active` flag is true
- **Departments** → distinct non-empty departments
- **Active Payroll** → sum of salaries for active employees

This fixes the previous static/empty dashboard statistics problem by providing a dedicated `/employees/stats` backend endpoint and connecting the frontend cards to it.

## 📸 Portfolio Screenshots

For a strong GitHub portfolio, capture screenshots from the real running application:

1. Login screen
2. Dashboard with populated statistics
3. Employee directory
4. Add employee form
5. Successful create/delete operation

## 🔭 Roadmap

- Employee update endpoint
- Search, filtering and pagination
- DTO layer and global exception handling
- Persistent users and database-backed roles
- Audit logging
- Docker Compose for application + MySQL
- OpenAPI / Swagger documentation

## 👨‍💻 Author

**Mayur Bhand**

- GitHub: https://github.com/BhandMB
- LinkedIn: https://www.linkedin.com/in/mayurbhand/
