# Dashboard Metric Definitions — 2026-09-22

| Metric | Definition | Verification |
|---|---|---|
| Total Employees | Count of employee records visible to the current role | Matches filtered repository query |
| Active Employees | Employees marked active under the current business rule | Excludes inactive or terminated records |
| Departments | Count of distinct departments represented by visible employees | No duplicate department inflation |
| Payroll | Current payroll summary for the selected period | Period and currency are explicit |

## Consistency rule
The dashboard, list views, and API responses must use the same filters and visibility rules. Any cached metric should have an explicit refresh or invalidation path.