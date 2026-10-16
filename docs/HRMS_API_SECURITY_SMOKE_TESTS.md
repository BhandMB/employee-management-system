# HRMS API Security Smoke Tests

Run these checks after authentication or authorization changes. Confirm the expected behavior against the project's current security policy.

## Authentication
- [ ] Protected endpoint rejects an unauthenticated request.
- [ ] Valid login works with a test account.
- [ ] Invalid credentials are rejected without revealing which field was wrong.
- [ ] Logout or token/session expiry behaves as designed.

## Authorization
- [ ] ADMIN can perform only the actions assigned to the admin role.
- [ ] HR can perform permitted HR workflows but cannot perform admin-only actions.
- [ ] EMPLOYEE can access their own permitted data only.
- [ ] Changing an employee ID in a request does not expose another employee's record.
- [ ] Direct API calls are protected even when the UI hides an action.

## Error handling and secrets
- [ ] 401 and 403 responses are consistent with the API contract.
- [ ] Responses do not include stack traces, password hashes, or tokens.
- [ ] Logs do not record credentials or authorization headers.
- [ ] Tests use disposable accounts and non-production data.