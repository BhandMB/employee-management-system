# HRMS Employee Data Access Review

Review employee records exposed through list, detail, search, export, and profile endpoints.

## Checks
- Require authentication on protected endpoints.
- Restrict employee self-service to the authenticated employee's linked record.
- Verify HR and administrator access against the role matrix.
- Apply the same authorization rules to exports and alternate response formats.
- Avoid returning salary, contact, or identity fields to roles that do not need them.

## Evidence and exit criteria
Record endpoint, role, expected result, actual result, and test identifier. Include allowed and denied cases. No endpoint may bypass the role policy; denied requests must not leak sensitive fields or record existence.