# Employee department transfer effective dating

## Purpose
Define how department changes affect employee records, reporting, and historical queries.

## Rules
- Store an effective-from date for every transfer; do not overwrite historical department assignments.
- Define whether the effective date is inclusive and which timezone governs date boundaries.
- Prevent overlapping active assignments unless concurrent assignments are an explicit business rule.
- Require an authorized actor and a reason for retroactive changes.
- Keep the employee's immutable identifier independent of department membership.

## Query behavior
Current-organization views use the assignment effective today. Historical reports use the assignment effective on the report date. Future-dated transfers must not alter current access or reporting prematurely.

## Verification
Test same-day transfers, future-dated transfers, retroactive corrections, overlapping ranges, month-end reporting, and an employee with no active assignment. Verify audit history and authorization scope after each transition.
