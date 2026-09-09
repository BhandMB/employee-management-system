# Audit Event Catalog

Record security-relevant actions with actor, action, target, timestamp, and outcome:

- Employee created, updated, deactivated, or deleted.
- Role or permission changed.
- Login success, login failure, and logout.
- Bulk import started, completed, or rejected.
- Sensitive profile fields viewed or exported.

Do not store passwords, tokens, or unnecessary personal data in audit payloads. Use stable event names so reports and alerts remain compatible as the UI changes.