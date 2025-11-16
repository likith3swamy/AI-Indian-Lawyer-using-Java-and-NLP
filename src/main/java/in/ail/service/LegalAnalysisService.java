package in.ail.service;

import in.ail.service.dto.QueryRequest;
import in.ail.service.dto.QueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LegalAnalysisService {

    private final RetrieverService retriever;
    private final RuleEngineService ruleEngine;
    private final RagSynthesizerService synthesizer;

    public LegalAnalysisService(RetrieverService retriever,
                                RuleEngineService ruleEngine,
                                RagSynthesizerService synthesizer) {
        this.retriever = retriever;
        this.ruleEngine = ruleEngine;
        this.synthesizer = synthesizer;
    }

    public QueryResponse analyze(QueryRequest request) {
        // 1. Retrieve relevant chunks
        var chunks = retriever.retrieve(request.question, 8);

        // 2. Run rule engine to get deterministic firings, structured facts
        var ruleFacts = ruleEngine.evaluate(request.question, chunks);

        // 3. Call RAG synthesizer with chunks + rule facts
        var output = synthesizer.synthesize(request.question, chunks, ruleFacts);

        QueryResponse resp = new QueryResponse();
        resp.answer = output.answer;
        resp.confidence = output.confidence;
        resp.sources = output.sources;
        resp.evidence = output.evidence;
        return resp;
    }
}