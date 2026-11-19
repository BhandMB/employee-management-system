# Session Revocation Policy

## Events requiring revocation
Consider invalidating active sessions after password reset, account disablement, role reduction, suspected compromise, and administrator-initiated sign-out-all actions.

## Policy decisions
- Define the maximum session lifetime and idle timeout.
- Specify whether role changes take effect immediately or at the next request.
- Ensure disabled accounts cannot continue using an existing authenticated session.
- Avoid exposing whether a username exists in public authentication responses.
- Keep session identifiers out of application logs.

## Verification
1. Disable an account with an active session and attempt a protected request.
2. Reduce a user's role and retry an operation that was previously permitted.
3. Reset a password and verify the documented session behavior.
4. Revoke one session without unintentionally revoking another user's sessions.
5. Confirm logout clears the relevant client-side authentication state.

## Evidence
Record the configured policy, security tests, and any limitations imposed by the session storage mechanism.