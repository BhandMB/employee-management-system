# Issue Triage Guide

Use this guide before implementing an issue.

## Classify
- **Bug:** existing behaviour violates an expected requirement.
- **Security:** authentication, authorization, secret handling, or data exposure concern.
- **Test gap:** behaviour works but lacks regression coverage.
- **Maintenance:** dependency, configuration, documentation, or code-quality improvement.
- **Feature:** new user-visible behaviour requiring an explicit requirement.

## Prioritize
1. Security and data-loss risks.
2. Reproducible functional bugs.
3. Broken tests and production reliability.
4. Missing regression coverage.
5. Maintenance and documentation.
6. New features with clear acceptance criteria.

For every bug fix, record the failure condition and add a regression test when practical.
