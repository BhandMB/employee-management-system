# QA Checklist — 2026-09-04

## Employee flows
- Create an employee with valid data.
- Reject missing or malformed required fields.
- Edit an employee and verify the updated values persist.
- Confirm search, filtering, and pagination remain stable together.
- Verify unauthorized roles cannot access restricted actions.
- Confirm delete/deactivation behavior is reflected in list and dashboard counts.

## Regression
- Run unit and integration tests.
- Check the API response status and error payload for each negative case.
