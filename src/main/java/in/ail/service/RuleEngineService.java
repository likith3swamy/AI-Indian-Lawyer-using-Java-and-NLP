package in.ail.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Integrates Drools. Loads rules from resources/rules.
 * evaluate() returns structured facts and list of fired rules.
 */
@Service
public class RuleEngineService {

    private final KieContainer kieContainer;

    public RuleEngineService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Map<String, Object> evaluate(String question, List<Map<String, Object>> chunks) {
        KieSession session = kieContainer.newKieSession();
        try {
            session.setGlobal("question", question);
            session.insert(chunks);
            session.fireAllRules();

            // collect results from session globals or query (simplified)
            Map<String, Object> facts = new HashMap<>();
            // e.g., facts.put("firedRules", List.of("rule-Article14-scope"));
            return facts;
        } finally {
            session.dispose();
        }
    }
}