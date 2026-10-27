# HRMS Dashboard Metrics Reconciliation

**Date:** 2026-10-27  
**Purpose:** Make dashboard counts traceable to database queries and business definitions.

## Metric contract

| Metric | Definition to confirm | Reconciliation check |
|---|---|---|
| Total employees | All employee records, or only non-deleted records if soft deletion is used | Compare dashboard count with the canonical employee query |
| Active employees | Employees whose status is explicitly active | Ensure null and inactive statuses are handled consistently |
| Departments | Distinct valid departments, or department-table row count | Avoid counting duplicate department names from employee rows |
| Payroll | State whether this is a monetary total, number of payroll records, or a period-specific summary | Confirm currency, date range, and status filters |

## Investigation sequence

1. Write down the intended definition for each card before changing SQL.
2. Run the underlying query directly against the same database used by the application.
3. Compare raw query results, service-layer values, API JSON, and rendered UI values.
4. Check joins for row multiplication and filters for role-specific differences.
5. Test empty data, inactive records, duplicate department assignments, and month boundaries.

## Acceptance criteria

- Each card has one documented definition and a named source query/service method.
- API response fields have stable names and numeric types.
- A test fixture with known records produces exact expected counts.
- UI formatting does not turn a valid zero into a missing value.
- No metric is labelled “Payroll” without explaining what the displayed number means.

**Note:** This checklist does not assert that any current dashboard defect has been fixed.