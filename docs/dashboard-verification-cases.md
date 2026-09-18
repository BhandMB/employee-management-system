# Dashboard Verification Cases

- Empty database: all count cards render zero without errors.
- One active employee: total and active counts both increase once.
- Inactive employee: total increases while active remains unchanged.
- Duplicate department names: department count follows the intended uniqueness rule.
- Payroll records with missing values: the dashboard remains stable and shows a safe fallback.
- ADMIN, HR, and EMPLOYEE roles: each sees only the metrics allowed by the product rules.
