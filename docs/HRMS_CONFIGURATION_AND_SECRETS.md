# HRMS Configuration and Secrets Handling

## Configuration principles
- Keep environment-specific settings outside source code where possible.
- Use environment variables or a deployment secret store for database credentials and signing keys.
- Do not commit real passwords, API tokens, private keys, or production connection strings.
- Provide safe example values in sample configuration files.
- Separate local development settings from production settings.

## Database setup checklist
- [ ] Document the supported database version.
- [ ] Explain how to create the application database and least-privilege database user.
- [ ] Confirm schema migrations or initialization behavior are reproducible.
- [ ] Verify startup fails clearly when required configuration is missing.
- [ ] Keep backups and restore procedures separate from application credentials.

## Production readiness
- [ ] Rotate any credential that may have been committed accidentally.
- [ ] Avoid exposing secrets in logs or error responses.
- [ ] Review CORS, session/token, and cookie settings for the chosen authentication design.
- [ ] Use HTTPS in deployed environments.
- [ ] Document how configuration changes are rolled out safely.

Never paste real secret values into this document; list variable names and their purpose only.