# Employee search and filter composition contract

## Contract
Filters must compose predictably and remain authorization-scoped. Search is not access control.

## Query behavior
- Apply the caller's permitted employee scope before user-supplied filters.
- Combine independent filters with AND semantics; values within a multi-select filter use OR semantics.
- Define whether text search is prefix, substring, or token-based and use the same rule across UI and API.
- Normalize blank strings to absent filters; reject unsupported sort fields.
- Use a stable secondary sort key (employee ID) when sort values tie.

## Pagination
Validate page index and size, cap size at a documented maximum, and return consistent metadata. Keep ordering stable across adjacent pages when records are unchanged. Consider cursor pagination if offset queries become expensive.

## Security
HR users see only permitted organizational scope. Employees cannot broaden results by changing query parameters. Avoid returning hidden fields and logging personal search terms.

## Test matrix
| Scenario | Expected result |
|---|---|
| No filters | Authorized employees only |
| Department + status | Both filters applied |
| Blank search | No text filter |
| Unsupported sort key | Validation error |
| Employee requests another department | No unauthorized records |
| Equal sort values | Stable ID tie-break |
