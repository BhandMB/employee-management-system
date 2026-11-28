# Employee record retention and anonymization review

## Scope
Create a review framework for retaining employee records after inactivity or separation. Actual periods must be set by applicable law and organizational policy, not guessed in application code.

## Data inventory
List profile fields, employment history, attendance, leave, payroll references, attachments, audit events, and backups. Identify each purpose, owner, retention trigger, and deletion/anonymization method.

## Controls
- Apply retention schedules consistently across primary databases, object storage, exports, and downstream systems.
- Preserve records subject to an authorized legal hold.
- Prefer irreversible anonymization where aggregate reporting needs remain.
- Keep referential integrity and payroll/audit obligations intact.
- Record completion evidence without copying the data being removed.

## Review checklist
Confirm legal/policy approval, dependency mapping, backup expiry behavior, access restriction during retention, and verification that anonymized records cannot reasonably be reidentified using retained fields.
