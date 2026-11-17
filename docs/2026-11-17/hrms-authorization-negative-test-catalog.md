# HRMS Authorization Negative Test Catalog

## Objective
Verify that protected operations reject callers who lack the required role or resource ownership.

## Test groups
- Anonymous caller requests employee list, detail, create, update, and delete routes.
- Employee attempts to read or modify another employee's record.
- HR user attempts an administrator-only operation.
- User with a stale session attempts an operation after role revocation.
- Caller changes path identifiers or request ownership fields to target another record.

## Assertions
Each denied request must leave persistent state unchanged, return the documented status and error shape, and avoid exposing protected record fields. Repeat checks through alternate routes and HTTP methods.