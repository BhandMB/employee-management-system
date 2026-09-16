# Attendance Data Rules

Attendance records should be predictable, auditable, and safe to recalculate.

## Rules
- A record belongs to one employee and one calendar date.
- Check-in must not occur after check-out.
- Duplicate submissions for the same employee and date should be handled explicitly.
- Time-zone assumptions must be documented at the API boundary.

## Access
Employees may view their own records. Administrative roles may review records according to role permissions, with server-side authorization.

## Tests
Cover first entry, duplicate entry, missing checkout, invalid time order, unauthorized access, and date-boundary behavior.