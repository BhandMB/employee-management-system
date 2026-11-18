# Employee Record Concurrency Handling

## Problem
Two authorized users may edit the same employee record at nearly the same time. Without a concurrency policy, the later save can silently overwrite earlier work.

## Recommended contract
- Add a version field to mutable employee records when supported by the persistence model.
- Return the version with read responses and require it on update requests.
- Reject stale updates with a clear conflict response rather than silently overwriting newer data.
- Keep conflict responses free of fields the caller is not authorized to view.

## User experience
- Explain that the record changed after it was opened.
- Offer a refresh-and-review path; do not automatically merge sensitive fields.
- Preserve unsaved form values locally when safe.

## Test matrix
| Scenario | Expected result |
|---|---|
| Update with current version | Save succeeds and version advances |
| Update with stale version | Conflict response; stored data remains unchanged |
| Two simultaneous updates | At most one stale write succeeds |
| Caller lacks record access | Authorization denial, not a version oracle |
| Validation failure | No partial update |

## Operational notes
Track conflict counts to identify high-contention workflows. Keep transaction boundaries narrow and ensure the version check occurs in the same transaction as the write.