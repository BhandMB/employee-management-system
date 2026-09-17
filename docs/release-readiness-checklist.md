# HRMS Release Readiness Checklist

- [ ] Database schema changes are reviewed and reversible.
- [ ] Role-based access checks cover ADMIN, HR, and EMPLOYEE paths.
- [ ] Validation and global error responses are verified.
- [ ] Employee search, filtering, and pagination behave consistently.
- [ ] Dashboard metrics match the underlying records.
- [ ] Swagger/OpenAPI documentation reflects current endpoints.
- [ ] Integration tests pass against a clean database.
- [ ] Secrets and environment-specific values are externalized.
- [ ] Docker or deployment configuration has been tested from a clean checkout.
- [ ] README setup steps match the current Java, Spring Boot, and database versions.
