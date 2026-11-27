# Employee API optimistic locking test plan

## Objective
Prevent a stale employee edit from overwriting a newer update made by another administrator.

## Preconditions
The employee entity exposes a version value (such as a JPA version column), and update requests carry the version last read by the client. Confirm implementation before enabling this contract.

## Scenarios
1. Read version N, update with N: succeeds and advances the version.
2. Two clients read N; first update succeeds; second receives a conflict.
3. Client refreshes after conflict and submits latest version: succeeds.
4. Validation failure does not advance the version.
5. Delete/deactivate racing with update follows a documented conflict policy.
6. Concurrent requests cannot both commit from the same version.

## API and UI
Return a stable conflict code and safe message; never expose database exception text. Preserve unsaved edits and offer reload/compare rather than silently retrying against fresh data.

## Evidence
Capture request/response examples, database versions, and correlation IDs. Run integration tests against the configured relational database because in-memory substitutes may not reproduce locking behavior.
