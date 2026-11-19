# Role Change Approval Workflow

## Objective
Make changes to application roles deliberate, attributable, and reviewable.

## Proposed workflow
1. An authorized administrator selects the target account and requested role change.
2. The system validates that the actor can grant the requested role and cannot grant privileges beyond their own authority.
3. The change is confirmed with a reason and recorded as an audit event.
4. The account's effective permissions are refreshed according to the session policy.
5. The actor receives a success or failure result without exposing sensitive account data.

## Safeguards
- Prevent removal of the final active administrator unless a recovery path exists.
- Require re-authentication for high-impact privilege changes where supported.
- Do not accept role names or user IDs as trusted authorization evidence from the client.
- Keep role assignment history rather than overwriting the only record of prior access.
- Alert or review unexpected privilege escalation patterns.

## Test scenarios
Cover self-promotion attempts, HR granting ADMIN, changes to the final administrator, disabled accounts, duplicate submissions, and stale sessions after a role change.