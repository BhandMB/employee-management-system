# HRMS Employee API Test Scenarios

Use this checklist against the current API routes and DTOs in a local development environment.

- [ ] Create an employee with a valid payload.
- [ ] Submit a payload with a missing required field.
- [ ] Submit invalid values for constrained fields.
- [ ] Retrieve an existing employee.
- [ ] Retrieve an employee ID that does not exist.
- [ ] Update an editable field and verify persistence.
- [ ] Attempt an update with invalid data.
- [ ] Verify unauthorized requests are rejected.
- [ ] Verify role restrictions for create, update, and delete operations.
- [ ] Confirm failed requests do not modify stored data.
- [ ] Confirm error responses do not reveal stack traces or sensitive information.

Record actual status codes and responses when executing these cases. This document is a plan, not a claim that tests have passed.