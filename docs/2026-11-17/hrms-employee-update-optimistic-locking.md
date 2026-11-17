# HRMS Employee Update Concurrency Strategy

## Risk
Two administrators may edit the same employee record and the later save can silently overwrite the earlier update.

## Strategy
Evaluate optimistic locking with a version field or an equivalent conditional update. Return a clear conflict response when the submitted version is stale; do not silently retry user edits against newer data.

## Verification
Submit two updates based on the same version. Confirm the first succeeds, the second receives a conflict, and the stored record contains no mixed or lost fields. Include concurrent updates to separate employees to ensure unrelated records do not conflict.