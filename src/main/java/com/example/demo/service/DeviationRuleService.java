public interface DeviationRuleService {

    Optional<DeviationRule> getRuleByCode(String ruleCode);

    List<DeviationRule> getActiveRules();
}
