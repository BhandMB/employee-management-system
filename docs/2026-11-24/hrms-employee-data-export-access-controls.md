# HRMS Employee Data Export Access Controls

## Scope
Define minimum controls for employee list and detail exports.

## Authorization
- Require authentication for every export request.
- Apply the same row-level visibility rules as the corresponding employee listing.
- Restrict sensitive fields to roles with a documented business need.
- Do not rely on hiding an export button in the UI as an authorization control.
- Re-check permissions when an asynchronous export is downloaded.

## Data minimization
Export only requested columns. Exclude credentials, password hashes, reset tokens, internal security flags, and unrelated personal data. Consider masking personal identifiers in broad operational reports.

## Operational safeguards
Apply a maximum row count or asynchronous job mechanism for large exports. Use unguessable, short-lived download references. Prevent one user from downloading another user's export by checking ownership and authorization on every retrieval.

## Audit events
Record requester, role, applied filters, selected columns, result count, timestamp, and completion status. Avoid storing the exported file contents in application logs.

## Verification matrix
- Anonymous request is denied.
- Employee role can export only permitted self data, if export is allowed at all.
- HR role receives only the authorized employee population.
- Admin access is logged and still excludes secrets.
- Tampering with an export job ID does not disclose another user's file.
- Expired download references are rejected.

## Release gate
Do not enable exports in production until role-based and row-level tests pass against the actual endpoint.
