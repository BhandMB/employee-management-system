# Security Checklist

Security review points for the Employee Management System.

## Secrets
- [ ] Database and application passwords come from environment variables or an approved secret store.
- [ ] No real credentials are committed to Git.
- [ ] Docker Compose fails when required secrets are missing.
- [ ] Shared or production deployments use strong, unique passwords.

## Authentication
- [ ] Passwords are stored using BCrypt rather than plaintext.
- [ ] Seed users are created only when they are missing.
- [ ] Development credentials are changed before deployment outside a local environment.

## Authorization
- [ ] Role checks are enforced server-side.
- [ ] ADMIN-only operations cannot be triggered by changing frontend controls.
- [ ] HR permissions do not implicitly grant delete access.
- [ ] EMPLOYEE requests cannot be used to access another employee's restricted data.

## Web protections
- [ ] CSRF protection remains enabled for browser state changes.
- [ ] Validation prevents malformed input from reaching persistence logic.
- [ ] Error responses do not expose secrets, stack traces, or database credentials.

## Deployment
- [ ] Production uses the production profile.
- [ ] Production schema management is not configured to recreate application data.
- [ ] Actuator exposure is reviewed before public deployment.
