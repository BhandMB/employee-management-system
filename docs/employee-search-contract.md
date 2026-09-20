# Employee Search Contract

The employee list endpoint should make filtering and pagination predictable for both the UI and API consumers.

## Request rules

- Search text should be optional and safely trimmed.
- Page number and page size should have documented defaults.
- Sort fields should be allow-listed rather than passed directly into a query.
- Empty search results should return a successful response with an empty collection, not a server error.

## Response rules

Return the employee items plus pagination metadata such as current page, page size, total elements, and total pages. Keep employee identifiers stable and omit fields the current role is not allowed to view.

## Authorization checks

- `ADMIN` may search and view all employees.
- `HR` may search and view the employee fields allowed by the application policy.
- `EMPLOYEE` should only see the records permitted by the assignment rule.

Add integration tests for default pagination, filtered results, invalid page values, and role-specific visibility.