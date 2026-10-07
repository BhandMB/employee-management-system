# Architecture Notes

The application follows a layered Spring Boot architecture:

```text
HTTP / Browser
     |
Spring Security + CSRF
     |
REST Controllers
     |
DTO / Validation
     |
Service Layer
     |
Spring Data JPA
     |
MySQL
```

## Boundaries

**Controllers** handle HTTP concerns and expose REST endpoints.

**DTOs** keep API contracts separate from persistence entities and provide a stable place for request/response validation.

**Services** contain application rules such as role-sensitive employee operations and dashboard calculations.

**Repositories** provide persistence access through Spring Data JPA.

**Global error handling** converts validation, not-found, conflict, and unexpected failures into consistent API responses.

## Cross-cutting concerns

- Spring Security provides authentication and role-based authorization.
- BCrypt protects stored passwords.
- OpenAPI/Swagger documents the REST contract.
- Actuator exposes operational health and metrics.
- Docker Compose provides a repeatable local application/database environment.
- GitHub Actions provides automated CI verification.

When extending the system, keep business rules in the service layer rather than duplicating authorization or validation logic in frontend JavaScript.
