# HRMS Pull Request Review Checklist

## Correctness
- [ ] Change matches the issue and acceptance criteria.
- [ ] Existing behavior and API contracts are preserved where required.
- [ ] Edge cases and failure paths are handled.

## Spring Boot and persistence
- [ ] Business logic stays in the appropriate service layer.
- [ ] DTOs are used where appropriate; entities are not accidentally exposed.
- [ ] Transactions are applied where multi-step writes require atomicity.
- [ ] Queries and database changes are reviewed for correctness.

## Security and validation
- [ ] Authorization is checked server-side.
- [ ] Input validation and safe error responses are present.
- [ ] Logs avoid passwords, tokens, and unnecessary personal data.

## Verification
- [ ] Relevant automated tests pass.
- [ ] Documentation and configuration examples are updated.
- [ ] Reviewer notes any untested areas explicitly.