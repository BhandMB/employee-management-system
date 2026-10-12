# HRMS Employee Lifecycle Guide

## Goal
Keep employee records consistent from onboarding through updates and offboarding.

## Onboarding checklist
- [ ] Validate required employee fields before persistence.
- [ ] Reject duplicate employee identifiers and duplicate email addresses.
- [ ] Assign the correct department and employment status.
- [ ] Keep account roles separate from employee profile data.
- [ ] Return a clear validation response when input is invalid.
- [ ] Add tests for valid onboarding, missing fields, and duplicate values.

## Updating a profile
- [ ] Load the existing employee before applying changes.
- [ ] Update only fields the caller is authorized to change.
- [ ] Validate department and status references.
- [ ] Preserve immutable identifiers and audit-sensitive fields.
- [ ] Return a DTO rather than exposing persistence entities.

## Offboarding
- [ ] Prefer a documented inactive/offboarded status when historical records must be retained.
- [ ] Prevent inactive employees from accessing protected features.
- [ ] Keep payroll and attendance history available to authorized roles.
- [ ] Test that an employee cannot view another employee's data.

## Verification
Run the project's Maven verification command and manually check ADMIN, HR, and EMPLOYEE permissions before release. Update this guide when lifecycle rules change.