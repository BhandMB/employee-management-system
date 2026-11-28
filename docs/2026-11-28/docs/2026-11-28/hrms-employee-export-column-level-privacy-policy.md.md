# Employee export column-level privacy policy

## Objective
Ensure employee exports contain only the data needed for the exporter's legitimate task.

## Policy
- Define approved export profiles by role and business purpose.
- Use explicit column allowlists; never serialize an entire entity by default.
- Exclude credentials, tokens, private notes, and sensitive financial or identity fields unless separately approved.
- Apply the same row-level authorization used by the employee list.
- Record exporter, purpose, filters, timestamp, and result count in an audit event.

## Delivery safeguards
Use generated filenames, safe CSV escaping, bounded export sizes, and protected temporary storage. Avoid exposing exports through public static paths. Expire temporary download links and prevent cache leakage.

## Tests
Compare ADMIN, HR, and EMPLOYEE exports; attempt query-parameter scope escalation; verify excluded columns; test formula-like CSV cells; and confirm audit records do not contain exported personal data.
