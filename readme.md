# HexaBank – Banking Platform 🚀🏦

A **full-stack** banking application built with:
- **Backend**: Java 17, Spring Boot 3, Spring Security (JWT, OAuth2), Spring Data JPA, Redis, PostgreSQL
- **Architecture**: Hexagonal (ports/adapters), Domain Driven Design (DDD), CQRS
- **Frontend**: Angular 17 (Material UI, NgRx, JWT Auth)
- **Infrastructure & DevOps**:
    - Docker & Docker Compose
    - CI/CD (GitHub Actions)
    - Cloud Deployment on AWS (ECS + RDS + S3 + CloudFront)
- **Testing**: JUnit 5, Mockito, Testcontainers, Cypress (end-to-end)
- **Security**: OWASP Top 10 (CSRF prevention, XSS, SQL injection, role-based access control)

---

## ✨ Key Features
- 👤 User management (secure signup/login, profiles, Admin/User roles)
- 💳 Bank account management (open, view, close accounts)
- 💰 Transactions: deposit, withdraw, transfer between accounts
- 📊 Transaction history (filtering, pagination, export to PDF/CSV)
- 🔔 Real-time notifications (WebSocket / SSE, Redis pub-sub)
- 🛡️ Enhanced security (Bcrypt hashing, expirable JWT, refresh tokens, audit logs)

---

## ⚙️ Installation & Setup

### 1. Backend
```bash
git clone https://github.com/your-account/hexa-bank.git
cd hexa-bank/backend
./mvnw clean install
docker-compose up -d
```

### 2. Frontend
```bash
cd ../frontend
npm install
npm start
```

### 3. Access the Application
- API REST: `http://localhost:8080/api/v1`
- Angular Frontend: `http://localhost:4200`

---

## 📂 Hexagonal Architecture

```
backend
 ┣ 📂 domain (business rules, entities)
 ┣ 📂 application (use cases, services)
 ┣ 📂 infrastructure (adapters: Spring Data, Redis, REST)
 ┣ 📂 config (Spring Boot + security)
 ┣ 📂 tests (unit & integration)
```

---

## ✅ Testing
- **Unit tests**: JUnit + AssertJ + Mockito
- **Integration tests**: Testcontainers (Postgres, Redis)
- **E2E**: Cypress for Angular

---

## 🚀 AWS Deployment
- API: ECS Fargate + RDS (Postgres) + ElastiCache (Redis)
- Frontend: S3 + CloudFront
- CI/CD: GitHub Actions (build → tests → docker push → auto deploy)

---
