# Authorization Test Matrix — 2026-09-07

| Scenario | Expected result |
|---|---|
| Unauthenticated user opens a protected page | Redirect to login or return 401 |
| Employee requests another employee's record | Return 403 or hide the record |
| HR reads employee directory | Allow read access |
| HR performs an admin-only mutation | Reject with 403 |
| Admin updates a valid employee | Persist the change and return success |
| User submits an invalid role value | Reject validation before persistence |

Use this matrix as a regression baseline whenever security rules or controller mappings change.