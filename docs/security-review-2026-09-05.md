# Security Review — September 5, 2026

- Confirm passwords are stored only as strong one-way hashes.
- Check that role checks are enforced server-side, not only in the UI.
- Validate and sanitize user-controlled input before persistence or rendering.
- Keep secrets, database credentials, and local environment files out of version control.
- Review access-denied behavior to ensure it does not disclose sensitive employee data.
