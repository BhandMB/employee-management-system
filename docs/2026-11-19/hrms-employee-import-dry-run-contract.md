# Employee Import Dry-Run Contract

## Purpose
Allow HR teams to inspect an employee import before committing records.

## Expected behavior
- Accept a bounded file size and supported file format.
- Parse rows without writing employee records during dry-run.
- Validate required fields, duplicate identifiers, department references, and field lengths.
- Return row numbers with actionable validation messages.
- Mask sensitive values in error summaries and logs.
- Apply the same authorization and data-scope rules as the final import.

## Commit phase
A confirmed import should reference the validated upload or immutable validation result. Revalidate critical constraints at commit time because database state may have changed since dry-run.

## Test matrix
Test empty files, malformed headers, duplicate rows, invalid dates, unknown departments, oversized files, partial row failures, and a duplicate employee created between dry-run and commit.

## Operational note
Define whether imports are all-or-nothing or allow valid rows only. Make that policy explicit to users before they confirm.