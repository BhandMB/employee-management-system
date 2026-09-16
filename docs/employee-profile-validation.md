# Employee Profile Validation

Employee profile updates should preserve valid, complete data without exposing internal persistence details.

## Required checks
- Validate required identity and contact fields on the server.
- Normalize values such as email casing and surrounding whitespace consistently.
- Reject invalid dates and impossible status transitions.
- Return field-level feedback without leaking stack traces.

## Authorization
- Verify that the acting role may update the requested employee.
- Prevent an employee from changing protected role or payroll fields unless explicitly allowed.

## Regression cases
Test valid updates, missing fields, malformed values, unauthorized updates, nonexistent employees, and persistence failures.