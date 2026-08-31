# REST API Guide

The API is served from the same Spring Boot application. Authenticate through `/login` first when using browser/session requests.

Interactive documentation: `/swagger-ui.html`  
OpenAPI JSON: `/v3/api-docs`

## Employee endpoints

| Method | Endpoint | Roles | Purpose |
|---|---|---|---|
| GET | `/employees` | ADMIN, HR, EMPLOYEE | Search/filter/paginate |
| GET | `/employees/{id}` | ADMIN, HR, EMPLOYEE | Get one employee |
| GET | `/employees/stats` | ADMIN, HR, EMPLOYEE | Dashboard analytics |
| POST | `/employees` | ADMIN, HR | Create |
| PUT | `/employees/{id}` | ADMIN, HR | Update |
| DELETE | `/employees/{id}` | ADMIN | Delete |

## Search and pagination

```text
GET /employees?search=anita&department=Engineering&active=true&page=0&size=10
```

The response is a Spring `Page` containing `content`, `totalElements`, `totalPages`, `number`, `size`, `first` and `last`.

## Create

```json
{"name":"Mayur Bhand","department":"Engineering","email":"mayur@example.com","salary":65000}
```

## Update

```http
PUT /employees/1
Content-Type: application/json
```

```json
{"name":"Mayur Bhand","department":"Engineering","email":"mayur@example.com","salary":70000,"active":true}
```

## Analytics

`GET /employees/stats` returns total employees, active employees, distinct departments, active payroll and department distribution.

## Error format

```json
{"timestamp":"2026-08-31T13:00:00Z","status":404,"message":"Employee not found: 99"}
```

Validation errors additionally contain a `fields` object.
