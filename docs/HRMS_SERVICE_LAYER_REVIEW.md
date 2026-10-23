# HRMS Service Layer Review Guide

Use this guide when reviewing service-layer changes.

## Responsibilities
- [ ] Keep business rules in the service layer rather than controllers.
- [ ] Use clear method names and focused responsibilities.
- [ ] Validate assumptions before performing writes.
- [ ] Use transactions where a multi-step operation must be atomic.
- [ ] Avoid returning persistence entities directly when DTOs are appropriate.

## Reliability and security
- [ ] Handle missing records consistently.
- [ ] Avoid leaking internal exceptions to API clients.
- [ ] Check authorization at the appropriate server-side boundary.
- [ ] Ensure failed operations do not leave partial state.

## Tests
- [ ] Cover successful behavior, invalid input, and not-found cases.
- [ ] Cover boundary conditions and relevant authorization rules.
- [ ] Keep tests repeatable and independent of real user data.