# Application QA Checklist — September 3, 2026

Use this checklist before considering an Employee Management System change ready.

## Authentication and authorization
- [ ] Login succeeds with valid credentials.
- [ ] Invalid credentials are rejected.
- [ ] ADMIN, HR, and EMPLOYEE permissions match the documented matrix.
- [ ] Admin-only deletion remains protected.

## Employee workflows
- [ ] Employee list loads correctly.
- [ ] Search, filtering, and pagination behave consistently.
- [ ] Create and update validation works.
- [ ] Dashboard totals match persisted records.

## API and operations
- [ ] Swagger/OpenAPI endpoints respond correctly.
- [ ] Health endpoint is available.
- [ ] `mvn clean test` passes.
- [ ] No credentials or secrets are committed.
