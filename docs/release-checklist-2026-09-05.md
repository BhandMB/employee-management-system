# Release Checklist — September 5, 2026

## Before release

- Build from a clean checkout using the documented Java and Maven versions.
- Run unit, integration, and controller tests.
- Verify database configuration is externalized and sample credentials are not production-ready.
- Exercise authentication, role boundaries, employee CRUD, search, and pagination.
- Confirm API documentation and README setup steps match the current code.

## After release

- Record the version and commit SHA.
- Review application logs for startup warnings and failed requests.
- Capture any follow-up improvements as tracked work rather than undocumented changes.