# HRMS Employee List: Filter and Pagination Contract

Date: 2026-11-20

## Purpose

Keep employee-list behavior predictable across the REST API, UI, and database query layer.

## Request contract

Document supported filters such as department, employment status, and a normalized search term. Define page numbering, default page size, maximum page size, and allowed sort fields. Reject unsupported sort fields rather than concatenating user input into SQL.

## Response contract

Return the current page, effective page size, total element count, total page count, and a stable list of employee DTOs. Avoid returning entity relationships or sensitive fields that the list view does not need.

## Query behavior

- Apply authorization scope before user-supplied filters.
- Use deterministic ordering with a unique tie-breaker.
- Define whether text matching is case-insensitive and how blank search terms behave.
- Avoid N+1 relationship loading for department labels.
- Consider indexes only after reviewing actual query plans and data volume.

## Verification

- [ ] Empty results retain a valid pagination envelope.
- [ ] Out-of-range pages have documented behavior.
- [ ] Invalid sort keys are rejected.
- [ ] Employee-scoped users cannot widen their data scope with filters.
- [ ] Repeated requests with the same data return stable ordering.

## Scope

Contract guidance only; no runtime behavior or performance result is claimed.