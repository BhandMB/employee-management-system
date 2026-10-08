# Observability Checklist

Use this checklist when changing production-facing HRMS behaviour.

## Health
- [ ] Application health endpoint remains available through the intended Actuator configuration.
- [ ] Database connectivity failures are visible through health reporting.
- [ ] Container health checks use an endpoint that does not require browser authentication.

## Logging
- [ ] Authentication failures do not log passwords, tokens, or other secrets.
- [ ] Errors include enough context to diagnose the failing operation without exposing sensitive employee data.
- [ ] Repeated failures are not logged in a tight loop.

## Metrics
- [ ] Dashboard counts are derived from persisted data.
- [ ] Changes to employee lifecycle behaviour are reflected in relevant operational checks.
