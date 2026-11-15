# Employee Import Validation Plan

## Validation stages
1. Check file type, size, encoding, and required headers before parsing.
2. Normalize whitespace and documented date formats.
3. Validate required fields, email format, employment status, and department references.
4. Detect duplicate employee identifiers and conflicting email addresses.
5. Produce row-level errors without silently dropping invalid records.

## Transaction behavior
Document either all-or-nothing import or explicitly supported partial import. Never leave a half-written employee record when a row fails.

## Test scenarios
Cover empty files, missing columns, malformed dates, duplicate rows, unknown departments, oversized input, and valid mixed-case data. The user receives a safe summary; logs contain no passwords or sensitive values.