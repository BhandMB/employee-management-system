# HRMS Database Migration Preflight

Date: 2026-11-20

## Before a migration

- Identify the schema change and affected tables, indexes, constraints, and application versions.
- Check whether the migration locks large tables or rewrites existing data.
- Confirm a recent backup and a tested restore procedure.
- Estimate migration duration using a representative non-production dataset.
- Verify the application can start with the intended schema version.

## Execution controls

Use versioned, repeatable migration scripts. Prefer additive changes before destructive cleanup. For column renames or type changes, consider an expand-and-contract sequence so old and new application versions can coexist during rollout.

## After migration

- Verify schema version and critical constraints.
- Run focused read/write smoke checks.
- Review application and database logs.
- Keep a documented rollback or forward-fix decision; restoring a backup may lose writes made after the backup.

## Evidence

Record migration identifier, operator, start/end time, backup reference, validation results, and any follow-up actions.

## Checklist

- [ ] Backup restore was recently demonstrated.
- [ ] Migration reviewed by another engineer.
- [ ] Locking and runtime impact assessed.
- [ ] Rollback/forward-fix plan approved.
- [ ] Post-migration checks defined.

## Scope

Operational guidance only; no migration was executed by this commit.