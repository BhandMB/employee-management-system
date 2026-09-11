# Employee Lifecycle Acceptance Cases

| Scenario | Expected result |
|---|---|
| Create employee with valid required fields | Employee is persisted and visible to authorized users |
| Create employee with duplicate email | Request is rejected with a clear validation error |
| Update employee department | New department is saved and reflected in list and detail views |
| Deactivate employee | Employee remains auditable but is excluded from active counts |
| Employee views another employee record | Access is denied unless the role permits it |

## Verification notes
- Check API response status and error payload.
- Confirm database state after each write.
- Confirm dashboard counts reflect active/inactive status.
