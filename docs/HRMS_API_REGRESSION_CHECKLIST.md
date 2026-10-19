# HRMS API Regression Checklist

Run these checks after changes to controllers, services, security rules, entities, or DTOs. Only mark a case complete after verifying it against the running application.

- [ ] Application starts with the documented configuration.
- [ ] Authentication succeeds with valid credentials and fails safely with invalid credentials.
- [ ] Public endpoints are limited to those intentionally configured as public.
- [ ] Employee list and detail endpoints enforce role and ownership rules.
- [ ] Create and update endpoints validate input and return documented status codes.
- [ ] Missing resources produce a consistent not-found response.
- [ ] Duplicate or conflicting data is handled predictably.
- [ ] Unexpected failures do not expose sensitive internal details.
- [ ] API documentation matches current routes and request DTOs.
- [ ] Automated tests pass from a clean checkout.