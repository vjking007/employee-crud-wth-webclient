# Employee CRUD Microservices

A Spring Boot Microservices project implementing full Employee CRUD operations with:

✅ WebClient-based inter-service communication
✅ Global Exception Handling
✅ Swagger/OpenAPI Documentation
✅ Docker Containerization
✅ Clean Architecture (DTO, Service, Mapper, Controller layers)

---

## 📦 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring WebFlux (WebClient)
- Spring Data JPA (for service DB layer)
- Swagger (springdoc-openapi)
- Docker & Docker Compose

---

## 🧱 Microservices

| Service           | Port | Description                                      |
|-------------------|------|--------------------------------------------------|
| `employee-service`| 8082 | CRUD API for Employee data (JPA + MSSQL) |
| `employee-client` | 8081 | Calls employee-service using WebClient            |

---

## 🔁 API Endpoints

### `employee-client` calls `employee-service` via WebClient

| Method | Endpoint                         | Description            |
|--------|----------------------------------|------------------------|
| GET    | `/client/employees`              | Get all employees      |
| GET    | `/client/employees/{id}`         | Get employee by ID     |
| POST   | `/client/employees`              | Create employee        |
| PUT    | `/client/employees/{id}`         | Update employee        |
| DELETE | `/client/employees/{id}`         | Delete employee        |

---

## 🔧 Run Locally

### Prerequisites:
- Java 17+
- Maven
- Docker (optional, for container run)

---

### 🧪 Local Run (without Docker)

```bash
# Terminal 1
cd employee-service
mvn clean spring-boot:run

# Terminal 2
cd employee-client
mvn clean spring-boot:run


