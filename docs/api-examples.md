# API Examples

The API is available at `http://localhost:8080` when the application is running.

## List employees

```bash
curl http://localhost:8080/employees
```

## Create an employee

```bash
curl -X POST http://localhost:8080/employees \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mayur Bhand",
    "department": "Engineering",
    "email": "mayur@example.com",
    "salary": 65000
  }'
```

## Delete an employee

```bash
curl -X DELETE http://localhost:8080/employees/1
```

## Typical response

```json
{
  "id": 1,
  "name": "Mayur Bhand",
  "department": "Engineering",
  "email": "mayur@example.com",
  "salary": 65000
}
```

## Error example

If an employee ID does not exist, the API returns an appropriate HTTP error response rather than silently succeeding. The exact response body is controlled by the Spring Boot exception handling configured by the application.

## Browser UI

The project also serves a Bootstrap-based employee dashboard from the Spring Boot application:

```text
http://localhost:8080/
```

For authentic UI screenshots, capture the running application locally after configuring MySQL. This keeps the repository documentation honest and shows the real application rather than a generated mockup.
