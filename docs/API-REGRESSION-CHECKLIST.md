# API Regression Checklist

Use this checklist before merging changes to employee-facing REST endpoints.

## Authentication and authorization
- [ ] Unauthenticated requests are rejected where authentication is required.
- [ ] ADMIN can create, update, and delete employees.
- [ ] HR can create and update employees but cannot delete them.
- [ ] EMPLOYEE access is limited to the employee data exposed by the application.
- [ ] CSRF protection remains enabled for browser-based state-changing requests.

## Validation and errors
- [ ] Invalid employee input returns a validation response instead of a server error.
- [ ] Missing employees return a not-found response.
- [ ] Duplicate/conflicting data returns a conflict response where applicable.
- [ ] Unexpected failures are handled by the global exception layer.

## Query behaviour
- [ ] Search and department filters can be combined.
- [ ] Active/inactive filtering behaves consistently.
- [ ] Pagination returns stable page metadata.
- [ ] Dashboard totals match the underlying employee data.

## Verification
Run the automated test suite before pushing:

```bash
mvn clean test
```

For API changes, also verify the generated OpenAPI/Swagger contract and manually exercise the affected endpoint in a local environment.
