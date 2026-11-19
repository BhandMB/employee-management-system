# HRMS API Contract Change Review

Date: 2026-11-19

## Purpose

Use this review before changing an existing employee-management API so that backend changes remain predictable for the web client and other consumers.

## Compatibility checks

- Preserve existing route paths and HTTP methods unless a versioned migration is planned.
- Do not rename or remove response fields without checking every known consumer.
- Keep date, time, decimal, and enum serialization formats explicit.
- Return consistent error response structures for validation, authorization, and missing-resource cases.
- Avoid exposing persistence entities directly; use response DTOs.
- Document pagination defaults, maximum page size, and sort-field allowlists.

## Authorization checks

- Verify the caller's role for each operation.
- Confirm that employee-scoped users can access only their own records.
- Test both allowed and denied cases; a hidden UI control is not an authorization boundary.
- Ensure error responses do not reveal another employee's private data.

## Test checklist

- [ ] Existing successful requests still deserialize correctly.
- [ ] Required-field validation returns a stable client error.
- [ ] Unknown or unsupported sort fields are rejected safely.
- [ ] Missing records return the documented not-found response.
- [ ] Unauthorized and forbidden requests are distinguished consistently.
- [ ] Integration tests cover the changed endpoint and its permissions.
- [ ] OpenAPI documentation matches the implemented request and response DTOs.

## Release decision

Record the affected endpoints, consumer impact, migration notes, test evidence, and rollback approach in the pull request. Do not mark the change release-ready until compatibility and authorization checks have evidence.

## Scope note

This document defines a review process; it does not claim that the listed tests have been executed or that any application behavior has changed.
