# HRMS API Compatibility Checklist

## Contract stability
- Keep request and response field names consistent across releases.
- Treat enum additions and required-field changes as compatibility-sensitive.
- Return documented status codes and a stable error response shape.
- Preserve pagination defaults and ordering guarantees.

## Verification
Compare the generated OpenAPI document against the previous release. Exercise create, update, list, and detail endpoints.

## Release gate
Breaking changes must be versioned or accompanied by a migration note and an approved client update plan.