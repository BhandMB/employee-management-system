# HRMS Employee Deactivation and Access Revocation Review

## Objective
Ensure employee deactivation consistently restricts access while preserving records required for business operations.

## Expected sequence
- Authorize the deactivation request and validate its effective date.
- Change employment status through a controlled transition.
- Revoke or disable application access according to policy.
- Invalidate active sessions and refresh credentials where supported.
- Preserve payroll, attendance, leave, and audit history.
- Confirm that scheduled jobs do not reactivate the account unexpectedly.

## Consistency requirements
Employment status and login status are related but distinct concepts. The system should define how a future-dated termination behaves and what happens to pending approvals owned by the employee.

## Verification
1. Deactivated user cannot authenticate.
2. Existing sessions are rejected after revocation takes effect.
3. Historical records remain accessible to authorized HR users.
4. Pending approvals are reassigned or escalated according to policy.
5. Repeated deactivation requests do not corrupt the audit trail.
6. An unauthorized user cannot reactivate the account.

## Operational safeguards
Provide a controlled correction workflow for accidental deactivation. Log the actor and reason for reactivation. Do not delete employee records merely to prevent login.
