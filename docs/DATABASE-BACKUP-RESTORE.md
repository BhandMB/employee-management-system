# Database Backup and Restore Runbook

This runbook is for the MySQL database used by the HRMS. Adapt host, database, and account values to the target environment; do not place passwords directly in shell history.

## Before a backup

- Confirm the target database and environment.
- Ensure the backup destination has sufficient space and restricted access.
- Use a database account authorized to perform the backup.
- Record the backup timestamp and application release.

## Backup example

Use an interactive password prompt rather than putting the password in the command line:

```bash
mysqldump --single-transaction --routines --triggers -u <backup-user> -p emsdb > emsdb-backup.sql
```

## Restore rehearsal

1. Restore into a separate, non-production database first.
2. Check that expected tables and representative row counts exist.
3. Start a compatible application build against the restored database.
4. Verify login, employee search, dashboard metrics, and a read-only workflow.
5. Record duration, failures, and any version/schema mismatch.

A backup is not considered reliable until a restore has been tested. Restrict access to backup files because they may contain employee personal data.
