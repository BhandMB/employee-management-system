# HRMS Database Change Checklist

Use this checklist for changes to entities, repositories, schema, or database configuration.

- [ ] Confirm the business requirement and affected data model.
- [ ] Review entity relationships, nullability, uniqueness, and indexes.
- [ ] Check whether existing records remain valid after the change.
- [ ] Prefer a versioned migration for deployed environments where the project supports migrations.
- [ ] Avoid destructive schema changes without a backup and rollback plan.
- [ ] Keep DTOs and API contracts aligned with persistence changes.
- [ ] Add repository or integration tests for changed query behavior.
- [ ] Verify empty tables and representative existing data.
- [ ] Document required environment or migration steps.
- [ ] Run the project's full verification command before release.

Never include production credentials or real employee personal data in examples.