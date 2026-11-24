# HRMS API Optimistic Locking Test Plan

## Goal
Prevent lost updates when two authorized users edit the same employee record concurrently.

## Contract
Expose a version field or HTTP entity tag on reads. Require the client to submit the version it observed when updating. A stale update should return a conflict response with a stable error code and a message instructing the client to reload.

## Test setup
Create one employee at version N. Read the same record through two independent clients, then submit two updates based on version N.

## Scenarios
1. First update succeeds and advances the version.
2. Second update using the stale version is rejected.
3. A client that reloads the latest version can update successfully.
4. A validation failure does not increment the version.
5. A rolled-back transaction does not leave a version increment.
6. Concurrent updates to different employees do not conflict.
7. Unauthorized users cannot use version fields to bypass authorization.

## Implementation notes
Use a persistence-layer version column or an equivalent conditional update. Ensure conflict exceptions are translated centrally and consistently. Avoid a read-then-write check that is not protected by the database transaction.

## Observability
Track conflict counts without logging full employee payloads. A high conflict rate may indicate stale UI state or an overly broad editing workflow.

## Exit criteria
The stale-write test is repeatable under integration-test concurrency and the API response is documented in OpenAPI.
