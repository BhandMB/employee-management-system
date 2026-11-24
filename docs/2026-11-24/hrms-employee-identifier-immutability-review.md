# HRMS Employee Identifier Immutability Review

## Objective
Review how employee identifiers are created, exposed, and protected from accidental mutation.

## Recommended rules
- Generate the internal primary key independently of a human-readable employee code.
- Treat employee code as immutable after activation unless a controlled correction workflow exists.
- Enforce uniqueness in the database, not only in application validation.
- Normalize case and whitespace consistently before uniqueness checks.
- Avoid using email address as the permanent employee identifier because email can change.
- Keep foreign-key relationships attached to stable internal IDs.

## Change workflow
If an employee code correction is permitted, require an authorized role, a reason, and an audit event containing old and new values. Reject changes that collide with an existing code. Do not silently rewrite historical payroll, attendance, or leave references.

## API considerations
Use request DTOs that omit immutable identifiers from ordinary update operations. Return the identifier as read-only response data. Reject unexpected attempts to modify it rather than silently ignoring the field.

## Test scenarios
1. Update profile fields while retaining the employee code.
2. Submit a different employee code through the normal update endpoint.
3. Attempt a case-only duplicate against an existing code.
4. Attempt a correction using an unauthorized role.
5. Verify historical records still resolve to the same employee after an approved correction.

## Evidence to retain
Capture API responses, database constraint behavior, authorization outcomes, and audit entries for each scenario.
