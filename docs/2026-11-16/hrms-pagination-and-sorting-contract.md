# HRMS Pagination and Sorting Contract

## API behavior
Document the default page size, maximum page size, page-number convention, stable sort fields, and behavior for invalid parameters.

## Correctness requirements
- Apply authorization filters before pagination.
- Use a deterministic secondary sort key to avoid unstable page boundaries.
- Return consistent total counts and page metadata.
- Reject or safely normalize unsupported sort fields.

## Test cases
Cover empty results, a final partial page, maximum page size, invalid page values, repeated sort values, and records hidden by role-based access.