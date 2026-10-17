# HRMS Role and Permission Review

This document is a review template. The application's `SecurityConfig` and method-level security remain the source of truth; update this matrix when implementation changes.

| Capability | ADMIN | HR | EMPLOYEE |
|---|---|---|---|
| View employee directory | Verify implementation | Verify implementation | Own-record scope should be enforced |
| Create employee | Expected | Expected if configured | Not expected |
| Update employee | Verify implementation | Verify implementation | Own profile only if explicitly supported |
| Delete employee | Expected only if configured | Not expected by current project rules | Not expected |
| Manage roles/users | Verify implementation | Not expected unless granted | Not expected |

## Review steps
1. Compare each row with route configuration and method annotations.
2. Test access as each role; do not rely on hidden UI controls as authorization.
3. Test direct API calls against restricted endpoints.
4. Confirm employee-level ownership checks prevent cross-employee access.
5. Keep tests aligned with the final implemented matrix.

## Security reminders
- Deny by default for newly added endpoints.
- Never trust a role or employee ID supplied by the client without server-side verification.
- Avoid returning password hashes, tokens, or unnecessary personal data in API responses.