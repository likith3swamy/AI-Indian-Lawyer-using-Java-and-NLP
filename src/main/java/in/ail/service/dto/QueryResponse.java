package in.ail.service.dto;

import java.util.List;
import java.util.Map;

public class QueryResponse {
    public String answer;
    public double confidence;
    public List<String> sources; // URIs of source docs or chunk IDs
    public Map<String, Object> evidence; // rule engine firings, scores, etc
}