# Audit Event Requirements

Record security-relevant HRMS actions with enough context to investigate changes.

## Events

- Authentication success and failure
- Employee creation, update, and deletion
- Role or permission changes
- Leave approval or rejection
- Payroll or compensation changes

## Minimum fields

- Event type
- Actor identity and role
- Target record identifier
- Timestamp in a consistent timezone
- Outcome: success or failure
- Correlation/request identifier when available

Do not store passwords, tokens, or unnecessary personal data in audit records.
