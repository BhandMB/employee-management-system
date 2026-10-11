# HRMS Release Checklist

## Before release
- Run the full test suite and confirm the build succeeds.
- Verify required environment variables and database migrations/configuration.
- Confirm production credentials are supplied securely and are not committed.
- Test login and ADMIN, HR, and EMPLOYEE permissions with representative accounts.
- Verify employee creation, editing, searching, and dashboard summaries.

## After deployment
- Check application health and startup logs.
- Exercise a read-only smoke test before testing writes.
- Confirm error responses do not leak implementation details.
- Record the release version and any known limitations.
