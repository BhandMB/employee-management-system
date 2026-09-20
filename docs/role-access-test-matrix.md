# Role Access Test Matrix

Use this matrix when changing controllers, services, or security configuration.

| Capability | ADMIN | HR | EMPLOYEE |
| --- | --- | --- | --- |
| View allowed employee list | Yes | Yes | Assignment-limited |
| Create employee | Yes | Yes | No |
| Update employee | Yes | Yes | No |
| Delete employee | Yes | No | No |
| View dashboard metrics | Yes | Policy-limited | Assignment-limited |
| Manage user roles | Yes | No | No |

Every protected endpoint should have at least one allowed-role test and one denied-role test. Also verify unauthenticated requests receive the configured authentication response and that method-level checks cannot be bypassed through alternate routes.