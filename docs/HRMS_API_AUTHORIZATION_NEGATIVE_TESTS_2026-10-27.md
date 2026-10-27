# HRMS Authorization Negative-Test Matrix

**Date:** 2026-10-27  
**Purpose:** Define repeatable checks for role-based access control. This is a test plan, not evidence that tests have already run.

## Test matrix

| Scenario | Expected result | Evidence to capture |
|---|---|---|
| Anonymous request to protected employee API | `401` or configured login redirect | HTTP status and response headers |
| EMPLOYEE requests another employee's record | `403` or deliberately non-disclosing `404` | Principal, target ID, status |
| EMPLOYEE attempts employee creation | `403` | Status and absence of persisted row |
| HR attempts employee deletion when deletion is ADMIN-only | `403` | Status and unchanged database row |
| ADMIN performs an allowed operation | Success response | Response and persisted change |
| User submits an invalid or expired session | Authentication challenge; no mutation | Status and unchanged data |

## Execution guidance

1. Use a disposable test database and seeded accounts for each role.
2. Assert both the HTTP result and the database state after denied writes.
3. Do not put real passwords, session cookies, or access tokens in test output.
4. Keep tests independent; reset records between cases.
5. Verify method-level security and HTTP request rules together so one layer cannot silently weaken the other.

## Completion checklist

- [ ] Each role has an explicit positive and negative test.
- [ ] Cross-employee access is tested using two distinct employee IDs.
- [ ] Denied write requests are confirmed not to mutate data.
- [ ] The test suite runs in CI with deterministic fixtures.
- [ ] Any intentional `401`/`403`/`404` policy is documented.