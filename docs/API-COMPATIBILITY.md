# API Compatibility Guidelines

Use these guidelines when changing REST endpoints consumed by the frontend or external clients.

## Prefer compatible changes

- Add optional response fields rather than renaming existing fields.
- Do not change a field's meaning or type without coordinating the consumers.
- Preserve established status codes and error response structure where practical.
- Treat pagination parameter defaults as part of the API contract.
- Keep authorization requirements explicit in endpoint documentation.

## When a breaking change is unavoidable

1. Describe the reason and affected consumers in the pull request.
2. Update OpenAPI documentation and examples.
3. Add tests for the new contract and relevant failure cases.
4. Provide a migration note or a versioning/deprecation plan.
5. Confirm frontend requests and role-based behaviour against the changed endpoint.
