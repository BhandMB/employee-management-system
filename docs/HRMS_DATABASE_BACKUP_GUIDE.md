# HRMS Database Backup Guide

This is an operational checklist for development and demo environments. Adapt commands to the configured MySQL version and deployment process before production use.

## Before backup
- [ ] Confirm the target database and environment.
- [ ] Ensure backup files are written to a protected location.
- [ ] Do not place database passwords in shell history or committed scripts.
- [ ] Record the backup time and application version.

## Backup and restore validation
- [ ] Use an approved MySQL backup method for the database size and consistency requirements.
- [ ] Verify that the backup file exists and is non-empty.
- [ ] Restore into a separate test database rather than overwriting the live database.
- [ ] Check expected tables, row counts, and key relationships after restore.
- [ ] Record the restore result and any missing steps.

## Data protection
- [ ] Limit access to backups because they may contain personal information.
- [ ] Encrypt backups when required by the environment.
- [ ] Define retention and secure deletion rules.
- [ ] Never commit real database dumps or credentials to Git.