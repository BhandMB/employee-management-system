# HRMS Release Readiness Checklist

Date: 2026-11-03

## Application
- [ ] Confirm supported Java and Spring Boot versions match the build configuration.
- [ ] Run a clean build and the complete automated test suite.
- [ ] Verify validation, global exception handling, and authorization paths.
- [ ] Check all navigation links and role-specific pages.

## Data and security
- [ ] Use a dedicated least-privilege database account.
- [ ] Supply secrets through environment variables or a secret manager.
- [ ] Disable or replace demo credentials before deployment.
- [ ] Confirm schema migration and backup/restore procedures.
- [ ] Ensure logs do not contain credentials, tokens, or sensitive employee data.

## Operations
- [ ] Configure health checks and application logging.
- [ ] Verify production profile and database connectivity.
- [ ] Document rollback steps and the previous known-good artifact.
- [ ] Perform smoke tests after deployment.

## Sign-off
Record build identifier, environment, test results, approver, deployment time, and rollback decision. Unchecked items must be explicitly accepted as risks; this checklist is not evidence that a release has occurred.