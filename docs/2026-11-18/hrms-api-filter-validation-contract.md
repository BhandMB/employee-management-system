# API Filter Validation Contract

## Objective
Make employee-list filters predictable, bounded, and safe for clients and the database.

## Input rules
- Validate page index and page size; reject negative values.
- Enforce a documented maximum page size.
- Allowlist sortable fields rather than interpolating arbitrary request values into SQL.
- Normalize and length-limit search text.
- Define whether date ranges are inclusive and reject start dates after end dates.
- Treat unknown enum values as validation errors instead of silently broadening results.

## Query behavior
- Apply authorization scope before pagination and counting.
- Use stable secondary sorting so records do not jump unpredictably between pages.
- Return total count and page metadata consistently.
- Ensure empty filters do not accidentally disable role restrictions.

## Tests
Cover boundary page sizes, unknown sort keys, malformed dates, long search terms, special characters, empty results, and role-scoped result counts.

## Compatibility
Document defaults and error response shape in the OpenAPI contract before changing existing clients.