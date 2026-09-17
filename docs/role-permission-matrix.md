# HRMS Role and Permission Matrix

| Capability | ADMIN | HR | EMPLOYEE |
|---|---:|---:|---:|
| View dashboard | Yes | Yes | Yes |
| View employee directory | Yes | Yes | Scoped access |
| Create employee | Yes | Yes | No |
| Update employee | Yes | Yes | Own profile or assigned scope |
| Delete employee | Yes | No | No |
| Manage roles and users | Yes | No | No |
| View own leave/payroll data | Yes | Yes | Yes |
| View all leave/payroll data | Yes | Yes | No |

## Implementation reminder

Enforce this matrix at the service and endpoint layers. UI hiding is not a security boundary. Every unauthorized action should return a consistent authorization response and leave the underlying record unchanged.
