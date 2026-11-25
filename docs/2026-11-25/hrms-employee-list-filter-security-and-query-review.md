# HRMS Employee List Filter Security and Query Review

## Scope
Review employee listing filters for authorization, correctness, and query safety.

## Authorization requirements
Apply row-level visibility before pagination and counting. An employee who can view only their own record must not infer other employees through total counts, autocomplete results, or filter facets.

## Input validation
- Allowlist sortable fields and sort directions.
- Validate page number and page size, with a configured maximum.
- Normalize text search consistently.
- Reject unsupported status and department filter values.
- Use parameterized query construction.
- Avoid exposing internal entity property names in API errors.

## Query behavior
Define whether multiple filters combine with AND semantics. Ensure pagination uses deterministic ordering with a stable secondary key. Review count queries separately from data queries so they apply identical visibility predicates.

## Test scenarios
- Employee requests another department's records.
- Employee manipulates page size to retrieve a larger dataset.
- Unknown sort field is supplied.
- Search text contains SQL metacharacters.
- Empty filters and whitespace-only search are submitted.
- Page boundaries and equal sort values are exercised.
- Count and returned rows are checked against the same authorization scope.

## Performance evidence
Use representative data volumes and capture query plans before adding indexes. Record latency and result size without including employee personal data in logs.
