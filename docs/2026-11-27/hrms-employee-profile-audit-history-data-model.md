# Employee profile audit history data model

## Goal
Provide traceable history of material employee-profile changes without creating an uncontrolled second employee database.

## Event fields
Event ID and timestamp; actor user ID and role; target employee ID; action name; request/correlation ID; changed field names and minimized before/after values; outcome and safe reason code.

## Recording rules
- Write the business update and audit event in the same transaction where feasible.
- Capture changes at the service boundary so UI and API updates follow one policy.
- Never record passwords, authentication tokens, full bank details, or unnecessary personal values.
- Restrict audit-history access separately from ordinary employee read permissions.
- Treat events as append-only; corrections should be new linked events.

## Operations
Define retention, archival, access review, and export controls. Use UTC timestamps. Monitor audit-write failures; a successful profile update must not silently lose its required audit record.

## Verification
Test field-level capture, rejected updates, actor attribution, concurrent updates, restricted audit access, and redaction. A failed transaction must not leave a misleading success event.
