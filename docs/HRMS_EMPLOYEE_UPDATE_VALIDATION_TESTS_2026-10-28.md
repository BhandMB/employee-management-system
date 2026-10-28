# HRMS Employee Update Validation Test Plan

**Date:** 2026-10-28  
**Purpose:** Define checks for safe employee profile updates. This document is a proposed test plan, not a claim that tests have run.

## Test matrix

| Case | Expected behavior |
|---|---|
| Valid update to editable fields | Success and persisted changes |
| Missing required field | Validation error; no partial update |
| Invalid email format | Validation error |
| Duplicate unique email or employee code | Conflict or documented validation response |
| Unknown employee ID | Not found response |
| EMPLOYEE updates another employee | Forbidden or non-disclosing not-found response |
| HR attempts an ADMIN-only field change | Denied or field ignored according to explicit policy |
| Malformed request body | Client error without stack trace |

## Verification steps

1. Seed two distinct employees and accounts with different roles.
2. Exercise the API using integration tests, not only direct service calls.
3. Assert response status and database state after both accepted and rejected requests.
4. Verify DTO mapping prevents server-managed fields from being overwritten by request data.
5. Record actual test command and results separately after execution.

## Acceptance criteria

- Validation constraints are explicit and tested.
- Unauthorized changes do not mutate records.
- Error responses are consistent and do not expose internal details.
- Update behavior for null, omitted, and blank fields is documented.