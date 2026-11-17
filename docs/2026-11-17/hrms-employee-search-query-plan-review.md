# HRMS Employee Search Query Plan Review

## Review scope
Inspect the database queries used by employee listing, filtering, sorting, and dashboard summaries.

## Checks
- Capture representative query plans with realistic row counts.
- Verify indexes align with commonly combined filters and sort keys.
- Check for N+1 access when rendering department or role details.
- Ensure count queries apply the same authorization and filter predicates as result queries.
- Bound page size and reject unsupported sort expressions.

## Evidence
Record query shape, dataset size, execution plan, observed latency, and proposed index changes. Validate improvements against write overhead before adding indexes.