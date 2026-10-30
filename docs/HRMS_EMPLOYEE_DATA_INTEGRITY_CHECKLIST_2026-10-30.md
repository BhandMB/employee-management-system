# HRMS Employee Data Integrity Checklist
Date: 2026-10-30

Review these invariants:
- Employee IDs and normalized email addresses are unique.
- Required fields reject null, blank, and whitespace-only values.
- Department references point to valid records.
- Date ranges are valid and use a consistent timezone convention.
- Currency uses decimal-safe storage and arithmetic.
- Multi-record changes use transaction boundaries.

API checks: validate DTOs, prevent mass assignment of privileged fields, return conflict for duplicate unique values, and define deactivation/history behavior.

Add tests for duplicate email, missing department, invalid dates, concurrent updates, and rollback after a failed multi-step operation.

Checklist only; verify against implementation before marking complete.