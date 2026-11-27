# Employee import: deduplication and replay safety

## Purpose
Define safe behavior when HR retries an employee CSV import after a timeout or partial failure.

## Identity and duplicate policy
- Use immutable employee number as the primary business identifier; do not deduplicate by name or email alone.
- Normalize whitespace and apply a documented case policy before comparing identifiers.
- Detect duplicates within the upload and against persisted employees.
- Never silently merge existing records; report conflicts for manual resolution.

## Processing contract
1. Validate file type, size, headers, row count, and required fields before writing.
2. Produce a dry-run summary with create, reject, and duplicate counts.
3. Associate accepted rows with an import batch ID and source row number.
4. Enforce a database uniqueness constraint as well as application validation.
5. On retry, recognize rows already committed for the same batch.

## Failure handling
Make the batch outcome explicit: completed, completed with rejected rows, or failed. Preserve row-level error codes without exposing SQL or personal data. Define whether processing is atomic or partially committed.

## Acceptance checks
- Replaying a batch creates no duplicates.
- Duplicate employee numbers in one file are reported.
- Concurrent imports cannot bypass uniqueness constraints.
- A malformed row does not corrupt unrelated accepted rows under the documented transaction policy.
- Logs contain correlation IDs, not full sensitive row contents.
