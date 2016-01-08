package miltos.diploma.parsers;

import java.util.ArrayList;

/**
 * A class that represents a PMD rule set.
 * It is just an ArrayList of Rule objects.
 * 
 * @author Miltos Siavvas
 *
 */
public class PmdRuleset {
	
	private ArrayList<Rule> ruleset = null;
	
	public PmdRuleset(){
		ruleset = new ArrayList<Rule>();
	}
	
	public void add(Rule rule){
		ruleset.add(rule);
	}
	
	public Rule remove(int index){
		return ruleset.remove(index);
	}
	
	public int size(){
		return ruleset.size();
	}
	
	public Rule getRule(int index){
		return ruleset.get(index);
	}

}
