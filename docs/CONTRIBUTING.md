# Contributing to the HRMS

## Before changing code
1. Identify the affected controller, service, repository, DTO, or security boundary.
2. Check existing tests and regression checklists for the affected behaviour.
3. Prefer a focused change over unrelated cleanup.

## Before committing
- Run `mvn clean test` when the local environment supports it.
- Review authorization behaviour for changed endpoints.
- Do not commit credentials, tokens, generated secrets, or local environment files.
- Keep commit messages specific to the change.

## Pull requests
Describe the problem, the implementation, tests performed, and any deployment or configuration impact. Include screenshots only when a UI change materially affects reviewers.
