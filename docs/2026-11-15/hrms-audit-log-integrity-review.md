# HRMS Audit Log Integrity Review

## Events to capture
Record security-sensitive actions such as role changes, employee record updates, payroll adjustments, leave approvals, and account deactivation.

## Integrity requirements
- Associate each event with an actor, timestamp, action, and target reference.
- Record before/after values only when necessary and safe to retain.
- Prevent ordinary application users from editing or deleting audit history.
- Use consistent event names and a documented retention policy.
- Ensure failed operations are distinguishable from committed changes.

## Verification
Test that a committed sensitive change creates one corresponding audit event, a rolled-back change is not represented as committed, and unauthorized users cannot alter audit records. Avoid writing credentials, tokens, or unnecessary personal data to the log.