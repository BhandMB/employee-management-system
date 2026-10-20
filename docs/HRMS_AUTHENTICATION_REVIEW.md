# HRMS Authentication Review Checklist

Use this checklist when reviewing login, session, and account security. It is a review aid; verify every item against the actual implementation.

- [ ] Login accepts only the documented credential format.
- [ ] Invalid credentials return a safe, consistent response.
- [ ] Passwords are stored using an appropriate one-way password encoder.
- [ ] Secrets and password hashes never appear in API responses or logs.
- [ ] Logout invalidates the session or token according to the configured authentication model.
- [ ] Disabled or deactivated accounts cannot authenticate.
- [ ] Protected endpoints require authentication on the server.
- [ ] Authentication failure and access-denied behavior are distinguishable and documented.
- [ ] Tests cover valid login, invalid login, logout, and protected-resource access.
- [ ] Default/demo credentials are not enabled in production deployments.