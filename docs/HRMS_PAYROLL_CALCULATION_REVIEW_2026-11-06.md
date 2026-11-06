# HRMS Payroll Calculation Review Guide

Date: 2026-11-06

## Calculation inputs
Document the pay period, employee eligibility, base salary, allowances, deductions, overtime rules, and rounding policy before implementing or reviewing calculations.

## Correctness checks
1. Use decimal arithmetic for currency; avoid binary floating-point calculations.
2. Define whether each component is monthly, per-day, or per-hour.
3. Specify rounding at component and final-total stages.
4. Validate effective dates and prevent duplicate payroll runs for the same employee and period.
5. Keep an auditable record of adjustments and approvals.
6. Protect payroll data with role-based access and employee ownership checks.

## Test cases
Include zero values, boundary values, mid-period changes, negative adjustments where permitted, and repeated generation attempts.

This guide is not legal or tax advice. Confirm jurisdiction-specific payroll rules with qualified sources and verify the application's actual calculation logic.