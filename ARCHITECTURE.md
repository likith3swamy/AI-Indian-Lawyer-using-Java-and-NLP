Overview
========
This file summarizes the architecture and recommended components.

Components
- Spring Boot API
- Ingestion pipeline: Parser -> Chunker -> Embedding -> Indexer
- Vector store: Elasticsearch (or Milvus/Weaviate)
- Rule engine: Drools
- LLM synthesizer: OpenAI or internal LLM via REST
- Database: PostgreSQL for document metadata and logging

Data flow
1. Ingest authoritative text (Constitution, judgments)
2. Preprocess and chunk (overlapping windows, store chunk metadata)
3. Create embeddings for chunks
4. Index chunks into vector store with metadata
5. Query flow:
   - User asks question via API
   - Retriever fetches top-N chunks (semantic + lexical)
   - Rule engine runs on retrieved chunks + query (fires deterministic rules)
   - Synthesizer (RAG) generates answer using retrieved chunks and rule outputs
   - Return final answer + provenance & rule evidence

Provenance and Safety
- Always show source passages & citations
- Include a confidence score
- Flag areas where LLM hallucination risk is high