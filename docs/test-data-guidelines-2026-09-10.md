# HRMS Test Data Guidelines — 2026-09-10

## Dataset rules
- Use deterministic IDs and dates so failures are reproducible.
- Keep valid, boundary, and invalid records in separate fixtures.
- Include examples for each supported role and permission boundary.
- Avoid real personal information in local or automated test data.

## Maintenance
- Update fixtures when validation rules change.
- Keep the smallest dataset that proves the behavior under test.
- Document any prerequisite seed order for integration tests.
