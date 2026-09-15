# Leave Workflow Acceptance Criteria

These cases define the expected behavior for a future leave-management implementation.

| Scenario | Expected result |
|---|---|
| Employee submits valid leave dates | Request is stored with a pending status |
| End date is before start date | Request is rejected with a validation message |
| Required reason is missing | Request is rejected without creating a record |
| Employee views another employee's request | Access is denied |
| HR reviews a pending request | HR can approve or reject according to role permissions |
| Already processed request is submitted again | Duplicate processing is prevented |
| Approved leave is viewed by the employee | Approval status and dates are visible |

## Invariants
- Leave dates must remain valid after persistence.
- Every status transition should be attributable to the acting user.
- Authorization must be enforced server-side.
- Repeated approval/rejection requests must not create conflicting states.
