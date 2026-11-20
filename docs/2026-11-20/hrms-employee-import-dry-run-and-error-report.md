# HRMS Employee Import: Dry-Run and Error Report

Date: 2026-11-20

## Goal

Define a safe preview stage for bulk employee imports before any records are persisted.

## Dry-run behavior

1. Parse the uploaded file and identify its format and header row.
2. Validate required columns, data types, field lengths, and supported enum values.
3. Normalize whitespace and documented date formats without silently changing user intent.
4. Check duplicate employee identifiers both within the file and against existing records.
5. Evaluate reference fields such as department IDs without creating missing departments.
6. Return a preview summary and row-level errors; do not write to the database.

## Suggested result structure

- fileName and totalRows
- validRows and invalidRows
- warnings for values normalized during preview
- row number, field name, error code, and safe user-facing message for each error

Do not include passwords, tokens, or unnecessary personal data in error output or logs.

## Commit stage

Require an explicit confirmation after preview. Revalidate on commit because records may have changed since the dry run. Use a transaction strategy that avoids partially importing a batch unless partial success is an explicit product requirement.

## Acceptance checks

- [ ] Invalid files are rejected before row processing.
- [ ] Duplicate identifiers are reported deterministically.
- [ ] Preview performs no writes.
- [ ] Commit rechecks uniqueness and references.
- [ ] Error reports identify rows without exposing sensitive values.

## Scope

This is a design document, not evidence that an import feature or tests have been implemented.