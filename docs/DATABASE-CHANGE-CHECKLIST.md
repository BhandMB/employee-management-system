# Database Change Checklist

Use this checklist for schema or persistence changes.

- [ ] Entity mappings match the intended table and column names.
- [ ] New required fields have a safe migration or initialization path.
- [ ] Existing records remain readable after the change.
- [ ] Repository queries are reviewed for pagination and filtering behaviour.
- [ ] Validation rules are consistent between DTOs and persistence constraints.
- [ ] Integration tests cover the changed persistence path.
- [ ] Docker/local database configuration remains compatible.
- [ ] Rollback impact is understood before release.
