# HRMS Authorization Matrix

Use this matrix as a review aid; keep it synchronized with the actual Spring Security configuration and method-level rules.

| Capability | ADMIN | HR | EMPLOYEE |
|---|---|---|---|
| View employee directory | Yes | Yes, within permitted scope | Own profile only |
| Create employee | Yes | Yes, if enabled by policy | No |
| Update employee | Yes | Yes, if enabled by policy | Own permitted fields only |
| Delete employee | Yes, if supported | No unless explicitly authorized | No |
| Manage roles and accounts | Restricted to admin policy | No by default | No |

## Review checklist
- [ ] Enforce access on the server, not only by hiding UI controls.
- [ ] Verify endpoint rules and method-level annotations agree.
- [ ] Ensure employee IDs supplied by clients cannot be used to access another person's record.
- [ ] Return 401 for unauthenticated requests and 403 for authenticated but unauthorized requests.
- [ ] Test every role against both allowed and denied actions.
- [ ] Avoid logging passwords, tokens, or sensitive profile information.

This is a proposed review baseline, not a claim that every permission is currently implemented. Confirm behavior against the code before treating the matrix as authoritative.