# HRMS Employee Status Transition Rules

Date: 2026-11-22

## Purpose
Define valid employee lifecycle transitions so that status changes remain auditable and do not bypass business controls.

## Transition model
Document the allowed transitions between pending, active, suspended, and separated states. Each transition must have an authorized actor, a reason code where required, and an effective timestamp. Reject unsupported transitions rather than coercing them into a default state.

## Data and access effects
Specify how each status affects login access, employee visibility, leave requests, payroll eligibility, and historical records. Preserve historical transactions when an employee becomes inactive; do not cascade-delete business history.

## Verification
- [ ] Every transition has an explicit permission rule.
- [ ] Invalid transitions are rejected server-side.
- [ ] Repeated requests do not duplicate audit events or side effects.
- [ ] Effective dates and timezone behavior are documented.
- [ ] Status changes are reflected consistently across dependent modules.

## Scope
This is a policy and test-design document, not evidence that lifecycle behavior has been implemented.