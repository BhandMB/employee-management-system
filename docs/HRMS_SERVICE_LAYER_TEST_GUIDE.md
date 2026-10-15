# HRMS Service-Layer Test Guide

## Purpose
Keep business rules testable independently of the web layer and database where practical.

## Employee service scenarios
- [ ] Create an employee with valid required fields.
- [ ] Reject missing or malformed required fields.
- [ ] Detect duplicate identifiers or email addresses according to project constraints.
- [ ] Update an existing employee and preserve fields not included in the update request.
- [ ] Return a predictable not-found result for an unknown employee ID.
- [ ] Confirm deletion or deactivation follows the project's retention policy.

## Test design
- Use descriptive test names that state the condition and expected outcome.
- Arrange test data explicitly; avoid dependence on execution order.
- Mock repositories for focused unit tests and use integration tests for persistence behavior.
- Assert meaningful outcomes and relevant side effects, not just that a method did not throw.
- Keep test fixtures minimal and readable.

## Verification before merge
- [ ] Run the targeted test class.
- [ ] Run the full Maven test/verification command available in the project.
- [ ] Check that tests clean up or isolate persistent data.
- [ ] Record any skipped tests and the reason for skipping them.