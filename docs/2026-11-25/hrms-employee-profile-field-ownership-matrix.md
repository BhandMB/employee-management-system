# HRMS Employee Profile Field Ownership Matrix

## Purpose
Clarify which roles may read or change employee profile fields, and which fields are maintained by the system.

## Ownership principles
- Employee-owned fields may be changed by the employee through a restricted self-service workflow.
- HR-managed fields require an HR or administrator permission.
- System-managed fields, such as internal IDs, audit timestamps, and derived status values, must not be accepted from ordinary client updates.
- Sensitive fields should be visible only to roles with a documented operational need.

## Suggested field groups
| Field group | Typical owner | Control |
|---|---|---|
| Contact details | Employee / HR | Validate and audit changes |
| Department and manager | HR | Effective-dated update |
| Employee code | System / HR correction | Immutable by default |
| Employment status | HR | State transition workflow |
| Internal ID and audit metadata | System | Read-only |
| Compensation data | Authorized payroll role | Restricted access |

## API design
Use separate DTOs for self-service updates and HR-managed updates. Do not bind request JSON directly to persistence entities. Reject attempts to submit system-managed fields.

## Verification
Test each role against each field group, including direct API calls that bypass the UI. Confirm that denied updates leave the database unchanged and produce an appropriate audit event.

## Review note
Adapt the field groups to the actual entity model before implementation; this matrix is a policy starting point, not a claim about current endpoint behavior.
