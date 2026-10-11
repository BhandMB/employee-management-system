# HRMS Security Test Plan

## Authentication
- Verify valid credentials establish an authenticated session or token as configured.
- Verify invalid credentials are rejected without revealing whether a username exists.
- Verify unauthenticated requests to protected endpoints are denied.

## Role authorization
- ADMIN: verify permitted employee administration actions.
- HR: verify permitted employee-management actions and confirm restricted delete operations are denied.
- EMPLOYEE: verify access is limited to the signed-in employee's allowed profile and records.

## Data validation
- Reject missing required fields, malformed identifiers, and invalid field values.
- Confirm errors do not include stack traces, SQL details, or secrets.

## Regression
- Run authentication and authorization integration tests after changes to security configuration.
- Recheck dashboard counts against persisted data and documented status rules.
