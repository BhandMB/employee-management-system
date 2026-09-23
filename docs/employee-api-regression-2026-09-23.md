# Employee API Regression Notes

## Coverage
- List endpoint returns stable pagination metadata.
- Search handles blank, partial, and case-insensitive values consistently.
- ADMIN and HR permissions are enforced for write operations.
- EMPLOYEE responses do not expose unauthorized records.
- Validation failures identify the rejected fields.
- Missing IDs return the documented not-found response.
