package miltos.diploma.parsers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.*;
import org.jdom.input.SAXBuilder;

/**
 * A class for importing all the rules found in a desired PMD rule set
 * xml file into a PmdRuleset object.
 * 
 * @author Miltos Siavvas
 *
 */

public class MyXMLRulesetReader {
	
	/**
	 * The method for importing the desired rule set.
	 * 
	 * @param path : The exact url where the rule set xml file is placed.
	 * @return ruleset : A PmdRuleset object containing the imported rules.
	 */
	public PmdRuleset parsePmdRuleset(String path){
		
		PmdRuleset tempRuleset = new PmdRuleset();
		
		try{
			/* Import the xml file and create the tree representation */
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(new File(path));
			Element rootNode = (Element) doc.getRootElement();		
			
			List<Element> ruleList = rootNode.getChildren();
			System.out.println("RuleList size = " + ruleList.size());
			PmdRuleset ruleset = new PmdRuleset();
			
			for (Element el : ruleList){
				
				/* Skip the description element. We focus only on the rule elements */
				if(el.getName().equals("description")) continue;
				
				/* Create a new rule object and get all its attributes from the xml file */
				Rule rule = new Rule();
				rule.setName(el.getAttributeValue("name"));
				System.out.println(el.getAttributeValue("name"));
				rule.setClazz(el.getAttributeValue("class"));
				rule.setLanguage(el.getAttributeValue("language"));
				rule.setSince(el.getAttributeValue("since"));
				rule.setMessage(el.getAttributeValue("message"));
				rule.seteExternalInfoUrl(el.getAttributeValue("externalInfoUrl"));
				
				/* Get the priority and the description of the current rule */
				List<Element> pr = el.getChildren();
				rule.setPriority(Integer.parseInt(pr.get(1).getText()));
				rule.setDescription(pr.get(0).getText());

				/* Add the rule to the rule set */
				ruleset.add(rule);
			}
			
			tempRuleset = ruleset;
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}catch(JDOMException je){
			System.out.println(je.getMessage());
		}
		/* Return the rule set */
		return tempRuleset;	
	}
}
