How to extend & next steps
1. Embeddings
   - Implement EmbeddingService to call OpenAI embeddings or local microservice.
   - Persist embeddings and chunk metadata in PostgreSQL and index vector in Elasticsearch.

2. Retriever
   - Implement RetrieverService to call Elasticsearch _search with script_score or KNN vectors.
   - Use hybrid scoring: combine BM25 + vector similarity.

3. RAG Synthesizer
   - Implement LLM client (OpenAI or self-hosted) with prompt templates that force citation and list fired rules.
   - Limit token budgets, chunk selection, and temperature.

4. Rule Engine
   - Convert legal knowledge into Drools rules carefully.
   - Keep rules auditable; log firings and facts.
   - Use versioned rulesets.

5. Datasets & Sources
   - Primary: Official Constitution of India text (gazette), Bare Acts, authoritative judgments.
   - Maintain metadata: section/article numbers, publication date, court, citation.

6. Evaluation
   - Create a test set with Q/A mapped to authoritative paragraphs & rulings.
   - Measure precision@k for retrieval and factual accuracy for the synthesizer.

7. Ethics & Legal
   - Add disclaimers: not a substitute for licensed legal advice.
   - Add logging and human-in-the-loop review for high-risk topics.

8. Deployment
   - Secure secrets (HashiCorp Vault, AWS Secrets Manager).
   - Add rate-limiting, authentication, and monitoring (Prometheus + Grafana).