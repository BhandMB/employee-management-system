# Employee Service Test Checklist

Use this checklist when reviewing employee-service behavior in a local test environment. Adapt cases to the current implementation and domain rules.

- [ ] Valid employee data is accepted.
- [ ] Required fields and constraints are validated.
- [ ] Updating an existing employee persists the intended changes.
- [ ] Updating a nonexistent employee returns the documented not-found response.
- [ ] Duplicate or conflicting data is handled consistently.
- [ ] Service errors do not expose internal implementation details.
- [ ] Failed operations do not leave partial or inconsistent data.
- [ ] Tests cover relevant boundary values and null/blank inputs.

Record the test command, environment, and observed results before marking any item complete. This checklist is not evidence that tests have passed.