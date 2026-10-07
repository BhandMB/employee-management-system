# Test Plan

The project uses unit, controller, and integration-style tests to protect core HRMS behaviour.

## Core scenarios

### Authentication and roles
- [ ] ADMIN login succeeds with configured credentials.
- [ ] HR login succeeds with configured credentials.
- [ ] EMPLOYEE login succeeds with configured credentials.
- [ ] Unauthorized users cannot perform protected operations.
- [ ] HR cannot delete employees.

### Employee lifecycle
- [ ] Valid employee creation succeeds.
- [ ] Invalid required fields are rejected.
- [ ] Existing employee updates persist correctly.
- [ ] Missing employee lookups return the expected error.
- [ ] Admin deletion removes the intended employee.

### Search and dashboard
- [ ] Search returns matching employees.
- [ ] Department filtering returns the expected subset.
- [ ] Active/inactive filtering is correct.
- [ ] Pagination metadata is consistent.
- [ ] Dashboard counts reflect persisted records.

## Local verification

Run the complete Maven test suite:

```bash
mvn clean test
```

When adding a regression test, prefer a test that reproduces the original failure and remains useful if the implementation changes.
