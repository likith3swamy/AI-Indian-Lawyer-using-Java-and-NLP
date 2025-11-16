package in.ail.controller;

import in.ail.service.LegalAnalysisService;
import in.ail.service.dto.QueryRequest;
import in.ail.service.dto.QueryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/query")
public class LegalQueryController {

    private final LegalAnalysisService service;

    public LegalQueryController(LegalAnalysisService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<QueryResponse> ask(@RequestBody QueryRequest request) {
        QueryResponse response = service.analyze(request);
        return ResponseEntity.ok(response);
    }
}