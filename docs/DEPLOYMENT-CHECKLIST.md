# Deployment Checklist

A repeatable release checklist for local, staging, and production deployments.

## Before release
- [ ] Confirm the target Java runtime is Java 17 or newer.
- [ ] Run `mvn clean test`.
- [ ] Build the application with `mvn clean package`.
- [ ] Review changed configuration and database migrations/schema assumptions.
- [ ] Confirm no credentials or local-only files are included in the commit.

## Docker release
- [ ] Set `DB_PASSWORD`, `APP_ADMIN_PASSWORD`, `APP_HR_PASSWORD`, and `APP_EMPLOYEE_PASSWORD`.
- [ ] Start with `docker compose up --build`.
- [ ] Confirm the application health endpoint responds successfully.
- [ ] Confirm the MySQL volume is persistent.

## Production release
- [ ] Use the production Spring profile.
- [ ] Point `DB_URL` at the managed MySQL instance.
- [ ] Use a secret-injection mechanism rather than committing credentials.
- [ ] Verify application logs contain no secrets.
- [ ] Smoke-test login, employee listing, create/update permissions, and admin-only deletion.

## Rollback
Keep the previous deployable application artifact available until the new version has passed its smoke tests. If a release fails, restore the previous application artifact and investigate the failing test, configuration, or database change before retrying.
