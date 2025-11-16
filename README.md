# AI Indian Lawyer (AIL)

AI Indian Lawyer (AIL) is a Java-based system that analyses and interprets the Constitution of India using a hybrid approach:
- Semantic retrieval (embeddings + vector search)
- LLM-based synthesis (RAG)
- Rule-based reasoning (Drools) for deterministic constitutional logic and provenance

Goals
- Provide accurate legal insights with citations to constitutional text and case law
- Maintain provenance and rule-firing evidence for answers
- Be auditable and configurable for legal teams

This repository is a starter scaffold. It contains:
- Spring Boot backend
- Ingestion skeleton & chunker
- Embeddings/Vector retrieval integration points
- Rule engine (Drools) sample
- Docker Compose for PostgreSQL and Elasticsearch

Quick start (development)
1. Install Docker and Docker Compose.
2. Create an OpenAI API key (or point to your embedding microservice).
3. Copy config values into src/main/resources/application.yml (see file).
4. Start the infra:
   docker-compose up -d
5. Build & run:
   mvn clean package
   java -jar target/ai-indian-lawyer-0.0.1-SNAPSHOT.jar

Endpoints (examples)
- POST /api/ingest/upload  -> Upload & ingest a document (PDF/TXT)
- POST /api/query         -> Ask a legal question (returns answer + sources + rule evidence)
- GET  /api/status        -> Service status

Security
- Add API auth (JWT or API key) before exposing the API
- Audit all queries & rule firings

See ARCHITECTURE.md for design details and EXTENDING.md for next steps.