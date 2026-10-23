# HRMS Database Migration Review

Before applying a schema or data migration:

- [ ] Review the change against the current schema and entity mappings.
- [ ] Check nullability, defaults, indexes, and foreign-key constraints.
- [ ] Consider existing production-like data and migration duration.
- [ ] Verify application compatibility during deployment.
- [ ] Prepare and test a backup and recovery procedure.
- [ ] Confirm rollback limitations, especially for destructive changes.
- [ ] Run migration tests against a disposable database.
- [ ] Verify data integrity after migration.
- [ ] Keep credentials out of migration scripts and logs.
- [ ] Document the migration owner and release notes.

Do not mark items complete until they have been checked in the target environment.