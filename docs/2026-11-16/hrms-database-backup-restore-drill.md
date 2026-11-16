# HRMS Database Backup and Restore Drill

## Preparation
Record database version, backup timestamp, retention period, encryption status, and the approved restore target.

## Drill
1. Take a backup using the documented procedure.
2. Restore it into an isolated environment.
3. Verify schema version, representative employee records, role assignments, and referential integrity.
4. Run application smoke tests against the restored database.
5. Record elapsed time, errors, and any data-loss window.

A backup is not considered verified until a restore has been completed successfully.