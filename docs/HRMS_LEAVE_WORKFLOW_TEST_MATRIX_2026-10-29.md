# HRMS Leave Workflow Test Matrix

**Date:** 2026-10-29  
**Purpose:** Define expected leave-request transitions and authorization checks. This is a proposed test plan, not a report of tests executed.

## Workflow scenarios

| Scenario | Expected behavior |
|---|---|
| Employee submits a valid leave request | Request is created in the initial pending state |
| Required dates or leave type are missing | Validation error; no request is created |
| End date is earlier than start date | Request is rejected with a clear validation response |
| Employee views their own requests | Only their authorized records are returned |
| Employee attempts to approve their own request | Denied unless an explicit policy allows it |
| Authorized HR/admin approves a pending request | Status changes once and audit information is recorded where supported |
| A request is approved twice | Second transition is rejected or handled idempotently according to policy |
| Unauthorized role attempts approval | Access denied and request remains unchanged |

## Test notes

- Define permitted transitions explicitly; do not allow arbitrary status updates from the client.
- Test both API authorization and service-level transition rules.
- Verify database state after rejected transitions.
- Document overlap, holiday, and balance rules only when the application implements them.

## Acceptance checklist

- [ ] State transition rules are documented.
- [ ] Role and ownership checks have positive and negative tests.
- [ ] Invalid requests do not create or mutate records.
- [ ] Audit metadata is verified where implemented.