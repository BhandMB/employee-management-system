# Dependency Update Review

Use this checklist when reviewing automated or manual dependency updates.

- [ ] Confirm the dependency and version are from the expected upstream project.
- [ ] Review release notes for breaking changes, security fixes, and required migration steps.
- [ ] Check Java and Spring Boot compatibility before merging framework updates.
- [ ] Run `mvn clean verify` and review the full CI result, including Docker image build.
- [ ] Inspect test failures instead of skipping or weakening tests to obtain a green build.
- [ ] Check for newly introduced transitive dependencies and license concerns where relevant.
- [ ] Deploy to a test environment and verify login, CRUD permissions, search, dashboard, and health endpoints for high-impact updates.
