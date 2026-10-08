# API Test Matrix

Use this matrix to keep REST endpoint coverage aligned with the HRMS authorization model.

| Area | ADMIN | HR | EMPLOYEE | Expected checks |
|---|---|---|---|---|
| Employee list | Read | Read | Scoped | authentication, visibility, pagination |
| Employee create | Yes | Yes | No | validation, persistence, authorization |
| Employee update | Yes | Yes | Scoped | validation, ownership, persistence |
| Employee delete | Yes | No | No | authorization and not-found handling |
| Dashboard | Read | Read | Scoped | totals and role visibility |

Every new endpoint should add at least one happy-path and one authorization/validation regression test.