# HRMS Employee List Pagination QA Plan

**Date:** 2026-10-28  
**Purpose:** Check that employee search, filters, sorting, and pagination work together predictably.

## Scenarios

- First and last pages return the correct records and metadata.
- Empty result sets display an intentional empty state, not an error.
- Search terms with spaces and mixed letter case behave consistently with the documented policy.
- Filters remain applied when navigating between pages.
- Changing a filter resets the page index when the current page could become invalid.
- Unsupported sort fields are rejected or ignored according to a clear contract.
- Equal sort values use deterministic ordering where stable pagination is needed.
- Role-specific visibility is enforced by the backend, not only hidden in the UI.

## Data checks

Use a fixture with enough employees to span multiple pages, including active/inactive records, different departments, and similar names. Verify page content and total counts use the same filters.

## Acceptance checklist

- [ ] Page size has a documented maximum.
- [ ] Search, filters, and sort parameters are validated.
- [ ] Empty, loading, and failure states are distinguishable.
- [ ] Tests cover combinations of search + filter + sort + pagination.
- [ ] API and UI metadata agree.