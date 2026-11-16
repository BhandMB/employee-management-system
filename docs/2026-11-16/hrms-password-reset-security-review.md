# HRMS Password Reset Security Review

## Required controls
- Use single-use, time-limited reset tokens generated with a cryptographically secure source.
- Store only a safe token representation where practical.
- Avoid revealing whether an email address belongs to an account.
- Invalidate a token after successful use and handle concurrent redemption safely.
- Notify the account owner after a password change without exposing the new password.

## Verification
Test expired, malformed, reused, and concurrently submitted tokens. Confirm that reset links and tokens never appear in application logs.