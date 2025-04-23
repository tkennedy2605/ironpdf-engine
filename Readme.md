# IronPDF License Hot-Reload Demo

This project runs two Spring Boot apps (`app1` and `app2`) that share a Redis‐backed license key and expose Swagger UI.

## Prerequisites

- Docker & Docker Compose
- (Optional) `redis-cli` for manual Redis inspection

---

## Quickstart with Docker

From the root of the project (where `docker-compose.yml` lives):

1. **Start up any running containers**
    ```bash
    docker-compose up -d --build

2. **Verify all three are Up**
    ```bash
    docker-compose ps

## Test

**Each application exposes its OpenAPI docs at:**

- App1: http://localhost:8081/swagger-ui/index.html

- App2: http://localhost:8082/swagger-ui/index.html