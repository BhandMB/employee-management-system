# HRMS Employee API Manual Test Scenarios

Use these scenarios when validating employee endpoints in a local development environment. Confirm the actual routes and required fields in the current application before running requests.

## Test setup
- Start the application and its configured database.
- Use a dedicated development database and test accounts only.
- Authenticate as ADMIN, HR, and EMPLOYEE separately.
- Record the request, status code, and response body for each scenario.

## Core scenarios

| Scenario | Suggested check | Expected result |
| --- | --- | --- |
| List employees | Request the employee collection as ADMIN | Successful response with the permitted employee data |
| Create employee | Submit a valid employee payload as ADMIN or HR | Employee is created and persisted |
| Invalid create request | Omit a required field or submit an invalid value | Validation error; no invalid record is persisted |
| Update employee | Change an editable field on an existing employee | Updated value is returned and persists after reload |
| Missing employee | Request an employee ID that does not exist | Consistent not-found response |
| Unauthorized request | Call a protected endpoint without authentication | Authentication is required |
| Forbidden operation | Attempt an ADMIN-only operation as HR | Access is denied |
| Employee data scope | Request another employee's record as EMPLOYEE | Access is limited according to the application's authorization policy |
| Delete employee | Attempt deletion with authorized and unauthorized roles | Role policy is enforced and database state matches the response |

## Regression checks
- Verify error responses do not expose stack traces, credentials, or sensitive internal details.
- Confirm failed validation and authorization checks do not modify persisted data.
- Re-run relevant scenarios after changes to security rules, DTOs, or employee services.
- Where possible, automate these scenarios as integration tests and run them with the project's verification command.

## Results log

| Date | Scenario | Result | Notes |
| --- | --- | --- | --- |
| YYYY-MM-DD | Example scenario | Not run | Replace with observed result |

> This document is a test plan, not evidence that these scenarios have already passed.
