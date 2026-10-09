# Security Policy

## Supported versions

Security fixes are intended for the latest version on the `main` branch. This portfolio project does not publish a formal support window for older releases.

## Reporting a vulnerability

Do not publish credentials, personal data, exploit payloads, or details that could put a deployed instance at risk in a public issue.

Use GitHub's private vulnerability reporting feature for this repository if it is enabled. If private reporting is unavailable, open a minimal issue asking for a private contact route without including exploit details.

Include the affected component, impact, prerequisites, and a safe reproduction summary. Allow time for triage before publicly disclosing technical details.

## Secret handling

Never commit database passwords, seeded-user passwords, access tokens, production data, or environment files. Rotate any secret that may have been exposed; deleting it from the latest commit alone does not invalidate it.
