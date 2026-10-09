# Application Incident Response

## First response

1. Record the start time, affected environment, observed symptoms, and recent release/configuration changes.
2. Check application health, container status, database connectivity, and recent logs.
3. Avoid copying credentials, session cookies, or sensitive employee data into tickets or chat.
4. If a security incident is suspected, restrict exposure and preserve relevant logs before making broad changes.

## Recovery

- Prefer a known-good release or configuration rollback when the change is understood.
- Do not run destructive schema commands against production as a first response.
- Validate authentication, role permissions, employee read/write paths, and dashboard metrics after recovery.
- Confirm monitoring is stable before closing the incident.

## Follow-up

Document impact, root cause, recovery steps, and a preventive action. Add a regression test for confirmed software defects where practical.
