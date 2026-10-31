# AI-Native Backend Development — Beginner Deliverables (Weeks 1–9)

A progressive Java 21 e-commerce backend project aligned to the supplied **AI-Native Backend Development Curriculum — Enhanced 2026 Edition** screenshots. Each `week-XX` folder contains its own submission evidence and working artefacts; the final Spring Boot application is in `src/`.

## Requirements
- JDK 21+
- Maven 3.9+
- PostgreSQL 15+ (optional for local quick start; H2 is the default)

## Run locally
```bash
mvn clean test
mvn spring-boot:run
```
The default H2 database is in-memory. Swagger UI: `http://localhost:8080/swagger-ui.html`; OpenAPI JSON: `http://localhost:8080/v3/api-docs`; H2 console: `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:commerce`, user `sa`, blank password).

## PostgreSQL profile
Create a database named `commerce`, then set environment variables and run:
```bash
export DB_URL='jdbc:postgresql://localhost:5432/commerce'
export DB_USERNAME='postgres'
export DB_PASSWORD='change-me'
mvn spring-boot:run -Dspring-boot.run.profiles=postgres
```
Never commit real credentials. The `postgres` profile reads credentials only from environment variables.

## Main API
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/v1/products` | List products; optional `q`, `minPrice`, `maxPrice`, `availableOnly` |
| GET | `/api/v1/products/{id}` | Product detail |
| POST | `/api/v1/products` | Create product |
| PUT | `/api/v1/products/{id}` | Update product |
| PATCH | `/api/v1/products/{id}/stock` | Adjust stock |
| GET | `/api/v1/customers` | List customers |
| POST | `/api/v1/customers` | Create customer |
| POST | `/api/v1/orders` | Place an order |
| GET | `/api/v1/orders/{id}` | Order detail |
| PATCH | `/api/v1/orders/{id}/status` | Change order status |
| GET | `/api/v1/reports/sales` | Sales summary |

## Project layout
- `src/main/java`: layered Spring Boot application (controller, service, repository, DTO, entity, exception, configuration).
- `src/test/java`: automated service/API tests.
- `week-01` … `week-09`: separately packaged weekly submissions, diagrams, sample data, SQL, contracts, and evidence templates.
- `docs`: architecture and API usage notes.

## Data and business rules
Prices use `BigDecimal`; order placement validates customer/product existence, positive quantities, stock, and non-empty lines. Stock is decremented transactionally. Orders begin as `PENDING`; allowed transitions are `PENDING -> PAID|CANCELLED`, `PAID -> SHIPPED|CANCELLED`, and `SHIPPED -> DELIVERED`. Delivered/cancelled orders are terminal. Sales totals include PAID, SHIPPED and DELIVERED orders.

## Curriculum submission checklist
See `SUBMISSION-CHECKLIST.md`. Replace the clearly marked learner-owned evidence templates with genuine screenshots, test output, reviewer comments, commit history and AI interaction records. This package does **not** fabricate Git commits, pull-request reviews, debugger screenshots, deployment URLs or personal learning evidence.
