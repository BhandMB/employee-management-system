# HRMS Employee Import: Rollback and Partial-Failure Policy

## Purpose
Define predictable behavior for bulk employee imports so operators can distinguish a fully accepted file from a partially processed one.

## Processing contract
1. Validate file type, size, required headers, and row count before processing.
2. Parse rows into a staging representation; do not write employee records during parsing.
3. Normalize values such as email and employee codes before duplicate checks.
4. Validate each row for required fields, valid department references, and permitted status values.
5. Present a dry-run summary with accepted, rejected, and duplicate rows.
6. Require an explicit confirmation before committing the accepted batch.

## Transaction strategy
Prefer one database transaction for a batch when its size is safely bounded. If chunking is required, assign a batch ID and persist each chunk's outcome. Never report a chunked import as globally atomic. A retry must not create duplicate employees; enforce a stable external row key or idempotency key.

## Failure handling
- A preflight failure rejects the entire file without writes.
- A row validation failure is reported with row number, field, and actionable reason.
- A database failure during an atomic commit rolls back the transaction.
- A chunk failure leaves the batch marked incomplete and resumable only after reconciliation.

## Audit evidence
Record uploader identity, timestamp, source filename, batch ID, counts, and final status. Do not log passwords, personal data beyond what is operationally necessary, or raw file contents.

## Acceptance checks
- Invalid headers produce zero writes.
- Duplicate rows are reported deterministically.
- Repeating a completed batch does not duplicate employees.
- A forced persistence error produces the documented rollback or incomplete-batch state.
- The downloadable error report does not expose unrelated employee records.
