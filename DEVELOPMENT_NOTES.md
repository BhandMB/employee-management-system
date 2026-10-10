# HRMS Access-Control Verification Checklist

Use this checklist when changing employee-management features.

- Confirm ADMIN, HR, and EMPLOYEE permissions at the service or method-security layer.
- Verify employees can access only their own permitted records.
- Validate DTO input and return consistent field-level validation errors.
- Check that update and delete operations enforce the intended role restrictions.
- Verify dashboard counts against persisted database records and documented business rules.
- Run integration tests for authentication, authorization, and core employee workflows.
- Keep credentials and environment-specific secrets out of source control.
