# Synergy
A multi‑service LinkedIn‑style platform developed using spring boot, react, microservices, SAGA design pattern, Kafka, MongoDB, MySQL


Auth-Service: JWT, OAuth2, Spring Security, RBAC; token validation and role claims; MySQL/MongoDB for users; controller/service/repository; circuit breaker, global exception handling.

User-Service: Profiles, connections, search/graph; MongoDB for schema flexibility; FeignClient, JPA, role-based controller methods, transactional guarantees.

Job-Service: Postings, applications, indexing, transactional integrity; MySQL, JPA; SAGA for distributed transactions using Kafka; pagination, sorting.

Message-Service: Real-time, async Kafka topic communication; persistent chat threads in MongoDB; Circuit breaker for delivery failures; WebSockets for UI.

Notification-Service: Spring Boot service consuming Kafka topics; pushes in-app/email/SMS notifications, supports async, batching, retries.

Feed-Service: Recent activity aggregation, posts, likes; denormalized MongoDB storage; Kafka events for activity propagation.

Gateway/API Layer: Spring Cloud Gateway or NGINX for routing, authentication (JWT Bearer), RBAC enforcement, CORS handling.

Resilience & Observability: Circuit breakers (Resilience4J), SAGA for multi-service transactions, GlobalExceptionHandler (@ControllerAdvice), logging integration with Splunk/AWS CloudWatch.

Testing & Documentation: Swagger/OpenAPI for endpoints, JUnit & Jest for backend/frontend unit tests.