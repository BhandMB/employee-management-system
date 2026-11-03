# HRMS Role Permission Verification Matrix

Date: 2026-11-03

| Capability | ADMIN | HR | EMPLOYEE |
|---|---|---|---|
| View employee directory | Allow | Allow | Restrict to own profile |
| Create employee | Allow | Allow | Deny |
| Update employee | Allow | Allow within policy | Restrict to own permitted fields |
| Delete employee | Allow | Deny | Deny |
| Manage roles and accounts | Allow | Deny unless explicitly delegated | Deny |
| View payroll or attendance | Allow by policy | Allow by policy | Own records only |

## Verification checklist
- Enforce authorization on the server, not only by hiding UI controls.
- Test direct URL access and crafted API requests for every denied operation.
- Confirm employee ownership checks use the authenticated principal.
- Return consistent 401 responses for unauthenticated requests and 403 responses for authenticated users lacking permission.
- Avoid exposing passwords, password hashes, or internal security details in responses and logs.

## Maintenance
Treat this matrix as a proposed baseline. Update it whenever product requirements or security configuration changes. Confirm actual controller and method-security rules before using it as evidence of implemented behavior.