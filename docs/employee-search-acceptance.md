# Employee Search Acceptance Criteria

- Search returns matching employees without exposing unauthorized records.
- Empty search returns the default paginated result.
- Pagination metadata is stable and understandable to the frontend.
- Sorting uses an explicit, documented field.
- Invalid page and size values return a safe validation response.
- ADMIN and HR can search according to their permissions; EMPLOYEE remains restricted to permitted data.
