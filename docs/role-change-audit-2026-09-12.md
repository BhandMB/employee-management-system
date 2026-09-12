# Role Change Audit Notes

## Every role change should record
- employee or user identifier
- previous role and new role
- actor who made the change
- timestamp
- reason or ticket reference

## Validation
- Reject unsupported roles.
- Require authorization before updating.
- Ensure the audit entry is written only after a successful change.
