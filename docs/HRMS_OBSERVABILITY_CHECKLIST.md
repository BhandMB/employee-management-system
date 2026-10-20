# HRMS Observability Checklist

Use this checklist to improve diagnosis during local development, demos, and deployment.

## Logs
- [ ] Record application startup and shutdown clearly.
- [ ] Include useful context for failed operations without logging sensitive employee data.
- [ ] Avoid passwords, tokens, session identifiers, and database credentials in logs.
- [ ] Keep exception details in server logs while returning safe client responses.

## Health and operations
- [ ] Document how to confirm application and database connectivity.
- [ ] Distinguish readiness from liveness checks when supported by the deployment.
- [ ] Document common startup and database-connection failures.
- [ ] Establish a process for reviewing recurring errors.

## Verification
- [ ] Trigger a known validation error and inspect the resulting log.
- [ ] Confirm failed requests do not expose stack traces to clients.
- [ ] Ensure log output is useful without revealing unnecessary personal information.