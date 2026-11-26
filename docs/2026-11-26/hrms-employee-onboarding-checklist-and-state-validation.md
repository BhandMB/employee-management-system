# HRMS Employee Onboarding Checklist and State Validation

## Purpose
Define a controlled onboarding sequence and the checks required before an employee becomes active in the HRMS.

## Workflow checkpoints
1. Create the employee record with a unique internal identifier.
2. Validate required identity, contact, department, and employment fields.
3. Assign the appropriate manager and role through authorized workflows.
4. Confirm required documents or references are present according to policy.
5. Activate access only when the employee record is approved.
6. Record the effective start date and onboarding completion status.

## State integrity
Separate employee employment status from onboarding task completion. A partially completed onboarding process must not accidentally grant active application access. Repeated activation requests should be idempotent.

## Authorization
HR may manage onboarding data within its scope. System-managed identifiers and audit metadata remain read-only. Employees should not be able to approve their own onboarding or assign privileged roles.

## Test scenarios
- Missing required field blocks activation.
- Duplicate employee code is rejected.
- Unauthorized role assignment is denied.
- Repeated activation does not create duplicate accounts.
- Future start date follows the configured access policy.
- Failed account provisioning leaves a recoverable onboarding state.

## Audit evidence
Retain actor, timestamp, status transition, reason, and provisioning outcome. Avoid storing secrets or unnecessary personal information in logs.
