# HRMS Employee API Contract Examples

**Date:** 2026-10-29  
**Purpose:** Provide a review checklist for employee API request and response examples. Confirm the actual endpoint paths and fields against the implementation before publishing them as definitive API documentation.

## Example request shape

```json
{
  "firstName": "Asha",
  "lastName": "Patel",
  "email": "asha@example.test",
  "department": "Engineering"
}
```

This payload is illustrative only. Use the field names, required values, and enum values actually accepted by the application.

## Contract review

- Required and optional fields are clearly distinguished.
- Server-managed fields such as database IDs, creation timestamps, and role assignments cannot be overwritten unintentionally.
- Validation errors have a stable response shape.
- Successful create/update responses document their status codes and returned fields.
- Unauthorized and missing-resource responses follow a consistent policy.
- Pagination, search, and sorting parameters have documented defaults and limits.
- Examples contain fake data and no credentials or personal information.

## Verification checklist

- [ ] Compare examples with controller DTOs and OpenAPI definitions.
- [ ] Add integration tests for the examples.
- [ ] Verify response bodies against the real application.
- [ ] Keep this document synchronized with any API changes.