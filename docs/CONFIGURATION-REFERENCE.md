# Configuration Reference

The application reads configuration from Spring properties with environment-variable overrides. Keep secrets outside source control.

| Variable | Purpose | Notes |
|---|---|---|
| `SERVER_PORT` | HTTP listen port | Defaults to `8080` |
| `DB_URL` | JDBC URL | Must point to the intended database |
| `DB_USERNAME` | Database account | Prefer a least-privilege account outside local development |
| `DB_PASSWORD` | Database password | Inject through environment or a secret manager |
| `DB_POOL_SIZE` | Hikari connection pool maximum | Defaults to `10`; size according to deployment capacity |
| `DDL_AUTO` | Hibernate schema behavior | Defaults to `update` locally; production should use `validate` with migrations applied separately |
| `APP_ADMIN_PASSWORD` | Seeded ADMIN password | Required by Docker Compose |
| `APP_HR_PASSWORD` | Seeded HR password | Required by Docker Compose |
| `APP_EMPLOYEE_PASSWORD` | Seeded EMPLOYEE password | Required by Docker Compose |

## Safe configuration checks

- Verify the active Spring profile before deployment.
- Use a dedicated database identity with only the permissions the application needs.
- Do not print secret values in logs or paste them into issue reports.
- Review Actuator exposure before publishing the application to an untrusted network.
