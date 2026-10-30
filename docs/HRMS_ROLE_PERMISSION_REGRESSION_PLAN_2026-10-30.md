# HRMS Role and Permission Regression Plan
Date: 2026-10-30

Test ADMIN, HR, and EMPLOYEE boundaries for directory access, create/update/delete, and access to another employee's record. Verify authentication failures return 401 and authenticated forbidden actions return 403.

Negative cases:
- HR attempts an ADMIN-only delete.
- EMPLOYEE attempts create, delete, or access another employee by changing an ID.
- Unauthenticated requests call protected endpoints.
- Request bodies attempt to overwrite role, status, or internal identifiers.

Acceptance: denied requests do not mutate data; authorization is enforced server-side, not only by UI visibility; sensitive changes are auditable.

This is a test plan, not evidence that tests have been executed.