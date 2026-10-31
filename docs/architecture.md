# Architecture

The final application follows a conventional layered design:

```mermaid
flowchart TD
  Client --> Controller[REST Controllers]
  Controller --> DTO[Request / Response DTOs]
  Controller --> Service[Application Services]
  Service --> Repository[Spring Data JPA Repositories]
  Repository --> DB[(H2 / PostgreSQL)]
  Controller --> Advice[Global Exception Handler]
```

Controllers own HTTP concerns; services enforce business rules and transactions; repositories own persistence; DTOs isolate the HTTP contract from persistence entities. Constructor injection is used throughout. Monetary calculations use `BigDecimal`; date/time values use `Instant`/`LocalDate`.
