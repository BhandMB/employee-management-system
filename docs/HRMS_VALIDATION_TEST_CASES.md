# HRMS Validation Test Cases

Use these cases to validate employee forms and API requests against the rules implemented by the application.

## Required fields and formats
- [ ] Missing required values produce a clear validation response.
- [ ] Whitespace-only values are handled consistently.
- [ ] Email values are validated and normalized according to project rules.
- [ ] Length limits are enforced for names and identifiers.
- [ ] Invalid dates and unsupported enum values are rejected.

## Data integrity
- [ ] Duplicate employee identifiers are rejected where uniqueness is required.
- [ ] Invalid requests do not persist partial changes.
- [ ] Update requests preserve fields that the caller is not allowed to modify.
- [ ] Error responses do not expose SQL statements or stack traces.

## Regression
- [ ] Test valid input at the minimum and maximum allowed boundaries.
- [ ] Test null, empty, malformed, and oversized values.
- [ ] Verify both service-level and HTTP-level behavior where applicable.
- [ ] Keep test expectations aligned with actual validation annotations and business rules.