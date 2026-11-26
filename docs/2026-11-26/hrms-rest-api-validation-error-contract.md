# HRMS REST API Validation Error Contract

## Purpose
Standardize validation responses so frontend clients can present actionable messages without depending on framework exception text.

## Response principles
A validation response should include a stable machine-readable error code, a safe summary, and field-level details where relevant. It should not expose stack traces, SQL messages, class names, or internal paths.

## Field error structure
For each invalid field, provide:
- Field name from the public request contract
- Stable validation code
- Human-readable message
- Optional rejected value only when it is safe to disclose

Do not echo passwords, tokens, or sensitive employee information.

## Consistency rules
Use the same response envelope across create and update endpoints. Distinguish malformed JSON, semantic validation failures, authentication failures, authorization failures, conflicts, and unexpected server errors.

## Test scenarios
- Missing required field
- Invalid email format
- Out-of-range numeric value
- Invalid enum or status
- Unknown request property
- Multiple field errors
- Sensitive field submitted with invalid content
- Validation failure with a correlation ID

## Documentation
Publish representative examples in OpenAPI and keep frontend field mapping synchronized with DTO property names.
