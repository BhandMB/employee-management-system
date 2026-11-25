# HRMS Department Transfer Effective-Date Test Cases

## Objective
Verify that department transfers take effect on the intended date without rewriting historical reporting.

## Expected behavior
A transfer should retain the previous department assignment and record the new department with an effective date. The application must define whether the effective date is inclusive and which timezone or business calendar governs it.

## Test scenarios
1. Transfer effective today.
2. Future-dated transfer displayed as pending until its effective date.
3. Backdated transfer submitted by an authorized HR user.
4. Transfer to an inactive or invalid department.
5. Two transfers with the same effective date.
6. Transfer request submitted twice.
7. Employee is transferred while a payroll period is being reviewed.
8. Historical reports continue to show the department applicable to the report period.

## Data integrity
Prevent overlapping active assignments unless the business rules explicitly support multiple departments. Preserve the actor, reason, old department, new department, and effective date.

## API and UI checks
Ensure the update DTO validates the department reference and effective date. Display pending changes distinctly from current assignments. Do not infer current department solely from the latest record if future-dated changes exist.

## Acceptance criteria
Current and historical department views agree with the effective-dated assignment history, and unauthorized users cannot create or alter transfers.
