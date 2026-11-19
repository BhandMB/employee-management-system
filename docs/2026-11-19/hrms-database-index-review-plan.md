# Database Index Review Plan

## Goal
Improve common HRMS query performance without adding unnecessary write overhead.

## Query inventory
Capture representative queries for employee lookup, department filtering, attendance by employee and date, leave requests by status, and payroll period retrieval.

## Review method
- Inspect actual query plans using representative data volumes.
- Identify predicates, joins, and sort columns used by frequent requests.
- Check existing primary-key and foreign-key indexes before proposing new ones.
- Prefer indexes aligned with common filter combinations.
- Consider selectivity, index size, and write amplification.
- Avoid speculative indexes based only on column names.

## Validation
Compare execution plans and latency before and after each candidate index. Confirm inserts and updates remain acceptable and that migrations can be applied safely.

## Deliverables
Maintain a record of query, observed plan, proposed index, measured result, storage impact, and decision. Do not claim performance improvement until measured.