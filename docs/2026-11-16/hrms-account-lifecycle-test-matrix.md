# HRMS Account Lifecycle Test Matrix

## Scenarios
- Create an account for a valid employee and verify the expected initial status.
- Disable and re-enable an account, checking that historical employee data remains intact.
- Attempt login with disabled, locked, and unknown accounts.
- Change an employee's role and verify that the new permissions take effect without stale authorization.
- Confirm that deleting or deactivating an employee follows the documented retention policy.

## Evidence
For each scenario, record actor role, preconditions, expected result, actual result, and test identifier. Never include passwords or session tokens in test evidence.