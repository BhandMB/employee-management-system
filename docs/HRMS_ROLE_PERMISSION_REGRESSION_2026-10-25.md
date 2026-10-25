# HRMS role permission regression checklist

Date: 2026-10-25

Verify ADMIN, HR, and EMPLOYEE access with a test database. Check protected pages and direct URLs, unauthorized mutations, employee record isolation, session expiry, and safe error responses. Record role, route, expected result, actual result, and evidence. Add integration tests for reproducible regressions.
