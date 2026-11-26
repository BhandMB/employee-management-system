# HRMS Database Migration Backward Compatibility Checklist

## Goal
Reduce deployment risk when application versions and database schemas change at different times.

## Migration review
- Identify tables, columns, indexes, constraints, and data affected.
- Check existing data for values that violate new constraints.
- Estimate lock duration and migration runtime.
- Confirm whether the migration is safe for the currently deployed application version.
- Define rollback or forward-fix behavior.

## Expand-and-contract approach
For changes that cannot be deployed atomically, consider adding compatible schema elements first, deploying code that supports both shapes, migrating data, and removing obsolete elements only after old code is no longer active.

## Data safety
Take and verify backups before high-risk changes. Prefer reversible transformations where practical. Do not assume a down migration can restore discarded data.

## Verification
Run migrations against a representative database snapshot. Test application startup before and after migration, and verify critical employee, role, attendance, leave, and payroll queries.

## Release gate
Record migration owner, expected duration, compatibility notes, backup evidence, and post-deployment validation results. Mark checks as passed only after execution.
