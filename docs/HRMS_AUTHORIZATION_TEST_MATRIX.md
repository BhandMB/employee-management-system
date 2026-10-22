# HRMS Authorization Test Matrix

Verify the application's actual security configuration before testing. Use development accounts and non-production data only.

| Operation | ADMIN | HR | EMPLOYEE | Unauthenticated |
|---|---|---|---|---|
| View permitted employee data | Verify policy | Verify policy | Verify own-data scope | Expect authentication where protected |
| Create employee | Verify policy | Verify policy | Verify denial or configured policy | Expect authentication where protected |
| Update employee | Verify policy | Verify policy | Verify own-record restrictions | Expect authentication where protected |
| Delete employee | Verify policy | Verify policy | Verify denial or configured policy | Expect authentication where protected |

- [ ] Confirm endpoint and method-level security rules.
- [ ] Verify denied requests do not change persisted data.
- [ ] Check that responses do not leak other employees' private information.
- [ ] Turn each discovered behavior into an automated integration test.

This matrix is a plan; fill in observed results based on the current code.