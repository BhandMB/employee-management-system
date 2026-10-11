# HRMS API Review Checklist

Before merging an API change:

- Use request and response DTOs rather than exposing persistence entities directly.
- Validate incoming payloads and return consistent client-readable validation errors.
- Check role-based access at the service or method-security boundary, not only in the UI.
- Return appropriate HTTP status codes for create, read, update, delete, and missing-resource cases.
- Keep pagination, filtering, and sorting behavior predictable for employee lists.
- Update OpenAPI/Swagger descriptions when routes or schemas change.
- Add tests for the success path, invalid input, missing data, and forbidden access.
