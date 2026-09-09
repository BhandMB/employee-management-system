# Employee Import Validation

## Required checks
- Employee identifier is unique within the system.
- Email addresses are normalized and validated before persistence.
- Department and role values match the allowed domain values.
- Dates use one documented format and reject impossible dates.
- Duplicate rows are reported with row numbers instead of silently overwriting data.

## Failure handling
Return a summary containing accepted rows, rejected rows, and actionable validation messages. Keep the operation atomic unless partial import behavior is explicitly documented.