# HRMS Pagination Verification Plan

Use this plan for employee-list endpoints that support pagination. Confirm actual endpoint behavior before treating any case as passed.

## Behavior
- [ ] Default page and size are documented.
- [ ] Requests for valid pages return the expected subset.
- [ ] Empty and out-of-range pages return a stable response.
- [ ] Maximum page size is bounded.
- [ ] Sorting is deterministic when multiple records share the same sort value.
- [ ] Search filters compose correctly with pagination.

## Edge cases
- [ ] Negative page values are rejected or normalized consistently.
- [ ] Zero and oversized page sizes follow the API contract.
- [ ] Unsupported sort properties do not cause an internal error.
- [ ] Empty datasets return correct metadata.

## Regression
- [ ] Total count and page metadata agree with the returned records.
- [ ] Tests cover more than one page of data.
- [ ] API documentation matches observed behavior.