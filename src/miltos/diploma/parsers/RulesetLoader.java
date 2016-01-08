package miltos.diploma.parsers;

/**
 * A class for testing the other three classes.
 * 
 * @author Miltos Siavvas
 *
 */
public class RulesetLoader {
	
	static final String ROULESET_SRC = "C:/Users/Miltos/Desktop/imports.xml";

	public static void main(String[] args) {
		
		MyXMLRulesetReader reader = new MyXMLRulesetReader();
		PmdRuleset ruleset = reader.parsePmdRuleset(ROULESET_SRC);
		
		/*
		 * For debugging purposes...
		 */
		System.out.println("Done");
		System.out.println(ruleset.size());
		
		Rule rule = null;
		for(int i = 0; i < ruleset.size(); i++){
			rule = ruleset.getRule(i);
			/*
			 * For debugging purposes...
			 */
			System.out.println("\n*** Rule " + i + " ***");
			System.out.println("* name: " + rule.getName());
			System.out.println("* language: " + rule.getLanguage());
			System.out.println("* since: " + rule.getSince());
			System.out.println("* message: " + rule.getMessage());
			System.out.println("* class: " + rule.getClazz());
			System.out.println("* externalInfoUrl: " + rule.getExternalInfoUrl());
			//System.out.println("* description: " + rule.getDescription());
			System.out.println("* priority: " + rule.getPriority());
		}
	}
}
