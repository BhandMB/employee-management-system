# HRMS Concurrent Employee Update Test Plan

Date: 2026-11-22

## Goal
Prevent silent overwrites when two authorized users edit the same employee record.

## Strategy
Choose and document an optimistic-locking or equivalent concurrency strategy. If version fields are used, include them in update requests and reject stale writes with a conflict response. The client should reload the latest record and let the user reconcile changes.

## Scenarios
- Two users read the same version and submit different updates.
- One update succeeds and the stale update is rejected.
- A retry uses the latest version.
- A failed update does not partially modify related records.
- Audit history identifies the successful actor and change.

## Acceptance criteria
- [ ] Concurrent updates cannot silently overwrite each other.
- [ ] Conflict responses are stable and actionable.
- [ ] UI preserves unsaved input when reporting a conflict.
- [ ] Version checks are applied consistently across update paths.
- [ ] Integration tests use separate transactions or sessions where needed.

## Scope
Test plan only; no concurrency test execution is represented.