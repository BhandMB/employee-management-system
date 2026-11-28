# Employee deactivation and reactivation acceptance matrix

## Lifecycle
Define explicit states such as ACTIVE, INACTIVE, and TERMINATED, including permitted transitions and the roles allowed to perform them.

## Deactivation controls
- Require a reason and effective date.
- Revoke application access according to policy without deleting employment history.
- Prevent new assignments or transactions that require an active employee.
- Preserve payroll, attendance, and audit records needed for lawful business retention.
- Make repeated deactivation requests idempotent.

## Reactivation controls
Require an authorized actor, reason, and effective date. Revalidate required profile fields and role assignments. Do not automatically restore privileged access that was removed during deactivation.

## Acceptance matrix
Test active-to-inactive, inactive-to-active, repeated requests, unauthorized actor, future effective date, employee with pending leave/payroll activity, and concurrent state changes. Confirm reports distinguish inactive employees from deleted records.
