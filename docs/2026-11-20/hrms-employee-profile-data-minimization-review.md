# HRMS Employee Profile: Data Minimization Review

Date: 2026-11-20

## Objective

Ensure each employee screen and API response exposes only the information required for its purpose.

## Review areas

- Separate fields needed for directory display from confidential HR records.
- Exclude authentication secrets, password hashes, reset tokens, and internal security metadata from all employee DTOs.
- Restrict compensation, government identifiers, and personal contact details to roles with a documented business need.
- Avoid copying sensitive fields into audit messages, exception text, analytics events, or browser storage.
- Define retention and deletion behavior for inactive employee records according to applicable organizational policy.

## Review questions

1. Which role needs each field?
2. Is the field necessary on this screen or endpoint?
3. Is the value exposed in list responses when only a detail view needs it?
4. Are exports subject to the same access rules as on-screen data?
5. Can logs and support diagnostics operate with redacted identifiers?

## Acceptance checklist

- [ ] DTOs are purpose-specific.
- [ ] Role-based field visibility is tested server-side.
- [ ] Export endpoints enforce equivalent permissions.
- [ ] Logs redact sensitive values.
- [ ] Retention rules are documented and approved.

## Scope

This review guide does not assert that a privacy audit has been completed.