# HRMS Employee Lifecycle Checklist

Use this checklist when reviewing employee onboarding, updates, and offboarding.

## Create employee
- [ ] Validate required fields and field formats.
- [ ] Reject duplicate identifiers such as employee code or email where uniqueness is required.
- [ ] Persist the employee and related records within a transaction when multiple writes are involved.
- [ ] Return a clear success response without exposing internal entity details.
- [ ] Verify that only authorized roles can create employees.

## Update employee
- [ ] Confirm the employee exists before applying changes.
- [ ] Validate changed fields and preserve immutable identifiers.
- [ ] Check authorization for the target employee and requested fields.
- [ ] Confirm invalid requests do not partially update data.
- [ ] Test not-found, validation, and conflict responses.

## Offboarding
- [ ] Prefer a documented inactive/deactivated state when historical records must be retained.
- [ ] Prevent deactivated accounts from authenticating.
- [ ] Preserve audit and payroll history according to the application's retention rules.
- [ ] Verify that the action is restricted to the appropriate role.

## Verification
- [ ] Add service and controller tests for successful and rejected operations.
- [ ] Check behavior against the configured database, not only mocked repositories.
- [ ] Document any lifecycle rules that differ from this checklist.