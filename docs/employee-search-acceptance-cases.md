# Employee Search Acceptance Cases

| Scenario | Expected result |
|---|---|
| Search by exact employee name | Matching employee is returned |
| Search with mixed letter case | Results are case-insensitive when supported |
| Search with leading/trailing spaces | Spaces are normalized or safely ignored |
| Filter by unknown department | Empty result with a successful response |
| Request page beyond the last page | Empty page, no server error |
| Unauthorized employee query | Access is denied without exposing other employee data |

Keep these cases aligned with controller, service, repository, and UI behavior.
