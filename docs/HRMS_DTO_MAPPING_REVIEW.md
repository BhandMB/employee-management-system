# HRMS DTO Mapping Review Checklist

Use this checklist when reviewing request and response DTOs.

- [ ] Controllers expose DTOs rather than persistence entities where appropriate.
- [ ] Request DTOs validate required fields and supported formats.
- [ ] Response DTOs omit password hashes, internal flags, and unrelated personal data.
- [ ] Mapping behavior is explicit and easy to test.
- [ ] Update mapping does not accidentally overwrite fields omitted by the client.
- [ ] Server-controlled fields such as IDs, roles, and audit timestamps cannot be freely assigned by callers.
- [ ] Nested relationships do not create accidental recursive JSON output.
- [ ] API examples reflect the current DTO shape.
- [ ] Tests cover valid mapping and invalid or unauthorized input.