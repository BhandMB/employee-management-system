# HRMS Dashboard Metric Definitions

Document the meaning of each dashboard metric so UI totals remain consistent with database records.

| Metric | Suggested definition | Validation |
|---|---|---|
| Total Employees | All employee records in scope | Compare against the employee table count |
| Active Employees | Employees whose status is active | Confirm inactive/offboarded records are excluded |
| Departments | Distinct valid departments represented by the department source | Check for duplicate names and orphan references |
| Payroll | Use the application's explicitly chosen period and payroll status | Display the period and currency clearly |

## Implementation notes
- Reuse service-layer queries where possible instead of calculating totals differently in multiple controllers.
- Define whether soft-deleted and inactive records count for each metric.
- Avoid hard-coded dashboard values.
- Handle an empty database without errors.
- Add tests for empty, normal, and mixed-status datasets.
- Ensure role-based access does not leak metrics beyond the viewer's scope.

## Release check
Compare each dashboard value with a direct, read-only database query using the same filters. Record the test dataset and expected result when fixing a metric discrepancy.