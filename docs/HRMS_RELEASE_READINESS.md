# HRMS Release Readiness Checklist

Complete this checklist before tagging a release or sharing a demo build.

## Application quality
- [ ] Run the project build and automated tests from a clean checkout.
- [ ] Verify login, logout, and session behavior.
- [ ] Verify role-based access through direct API requests.
- [ ] Check employee create, read, update, and configured delete/deactivation flows.
- [ ] Check validation errors and global exception responses.

## Data and configuration
- [ ] Confirm schema changes are repeatable and documented.
- [ ] Keep credentials outside version control.
- [ ] Document required environment variables and safe example values.
- [ ] Confirm startup behavior when the database is unavailable.
- [ ] Review logs for secrets or sensitive personal data.

## API and usability
- [ ] Confirm OpenAPI/Swagger documentation matches the endpoints.
- [ ] Verify pagination, filtering, and empty-state behavior where implemented.
- [ ] Check accessible labels and clear validation messages on forms.
- [ ] Ensure demo data is clearly identified and non-sensitive.

## Delivery
- [ ] Update README setup and test instructions.
- [ ] Record known limitations honestly.
- [ ] Verify the release commit and repository status.