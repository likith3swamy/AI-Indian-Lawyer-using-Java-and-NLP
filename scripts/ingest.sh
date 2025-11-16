#!/usr/bin/env bash
# Example ingest script (very simple)
# Usage: ./ingest.sh path/to/constitution.txt

FILE="$1"
if [ -z "$FILE" ]; then
  echo "Usage: $0 <file>"
  exit 1
fi

# chunk text into paragraphs and POST to ingestion endpoint
split -p '^$' -b 100k "$FILE" tmp_chunks_  # naive; you can make more advanced chunker

for f in tmp_chunks_*; do
  echo "Ingesting $f"
  curl -X POST "http://localhost:8080/api/ingest/upload" \
    -H "Content-Type: text/plain" \
    --data-binary @"$f"
done

rm tmp_chunks_*