# HRMS Audit Event Catalog

Date: 2026-11-06

## Events worth recording
- Authentication success and failure
- Employee creation, update, activation, and deactivation
- Role or permission changes
- Leave request submission and decision
- Attendance correction
- Payroll generation or adjustment
- Administrative configuration changes

## Event fields
Capture event ID, timestamp, actor ID, action, target type and ID, outcome, and correlation ID. Store only the minimum before/after data needed for accountability.

## Security requirements
Never record passwords, password hashes, session tokens, or unnecessary personal data. Restrict audit-log access and define retention and export policies.

## Review questions
Can an auditor identify who changed a record, when it happened, and whether it succeeded? Are failed attempts distinguishable from successful changes? Confirm the actual event implementation before describing any event as supported.