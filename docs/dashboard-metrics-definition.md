# Dashboard Metrics Definition

Use one definition per dashboard metric so the UI, service layer, and database queries stay aligned.

- **Total Employees:** count of employee records visible to the signed-in role.
- **Active Employees:** visible employees whose employment status is active.
- **Departments:** count of distinct departments represented by visible employees or configured department records, depending on the implemented data model.
- **Payroll:** the metric must state whether it represents the latest payroll run, current-month payroll total, or a count of payroll records.

## Verification

For each metric, test an empty database, one record, multiple records, and role-restricted visibility. Confirm that the dashboard does not display stale seed values after create, update, or delete operations.