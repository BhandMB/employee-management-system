# HRMS Application Readiness Checklist

## Configuration
- [ ] Database credentials supplied through environment or secret management.
- [ ] No production secret committed to source control.
- [ ] Active profile and external service endpoints reviewed.
- [ ] Connection pool, request size, and timeout limits configured.

## Security
- [ ] Role checks enforced on the server for every protected operation.
- [ ] Passwords hashed with an approved adaptive password encoder.
- [ ] CSRF, session, and cookie settings reviewed for the deployment model.
- [ ] Sensitive fields and tokens excluded from logs.
- [ ] Demo accounts disabled or credentials rotated.

## Data and reliability
- [ ] Database backup and restore procedure tested.
- [ ] Schema migration reviewed and repeatable.
- [ ] Health checks distinguish liveness from readiness.
- [ ] Error responses do not disclose internal implementation details.

## Quality gates
- [ ] Unit and integration tests pass in a clean environment.
- [ ] Authorization tests cover ADMIN, HR, and EMPLOYEE.
- [ ] Build artifact and dependency versions recorded.
- [ ] Rollback steps and release approval owner documented.

## Sign-off
Record build identifier, test evidence, deployment target, approver, and unresolved risks. This checklist is a gate, not evidence that any item has already passed.