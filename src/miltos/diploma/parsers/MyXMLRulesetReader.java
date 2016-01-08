package miltos.diploma.parsers;

import java.io.File;
import java.io.IOException;
import java.util.List;


/*
 * Import the JDOM API libraries...
 */
import org.jdom.*;
import org.jdom.input.SAXBuilder;

/**
 * A class for importing all the rules found in a desired PMD rule set
 * xml file into a PmdRuleset object.
 * 
 * @author Miltos
 *
 */

public class MyXMLRulesetReader {
	
	/**
	 * The method for importing the desired rule set.
	 * 
	 * @param path : The exact url where the rule set is placed.
	 * @return ruleset : A PmdRuleset object containing the imported rules.
	 */
	public PmdRuleset parsePmdRuleset(String path){
		int i = -1;
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
				i++;
				Rule rule = new Rule();
				rule.setName(el.getAttributeValue("name"));
				System.out.println(el.getAttributeValue("name"));
				rule.setClazz(el.getAttributeValue("class"));
				rule.setLanguage(el.getAttributeValue("language"));
				rule.setSince(el.getAttributeValue("since"));
				rule.setMessage(el.getAttributeValue("message"));
				rule.seteExternalInfoUrl(el.getAttributeValue("externalInfoUrl"));
				
				/* Little Hack to get the priority value of the rule */
				
				List<Element> pr = el.getChildren();
				if (i == 0) continue;
				Element desc = pr.get(0);
				Element pri = pr.get(1);
				System.out.println(pri.getName());
				System.out.println(pri.getText());
				
				//Not working!!!
				//String e = el.getChildText("priority");
				//if (e == null) System.out.println("NUUUUUUULLLLL");
				//if (i == 0) continue;
				
				rule.setPriority(Integer.parseInt(pri.getText()));
				rule.setDescription(desc.getText());
				
				//Alternatively...
				//rule.setDescription(el.getChildText("description"));
				//rule.setPriority(Integer.parseInt(el.getChildText("description")));
				ruleset.add(rule);
			
			}
			
			System.out.println("size : " + ruleset.size());
			tempRuleset = ruleset;
			//return ruleset;  ????????????????????? Why should i use a temp object instead of returning directly this one?

		}catch(IOException e){
			System.out.println(e.getMessage());
		}catch(JDOMException je){
			System.out.println(je.getMessage());
		}
		return tempRuleset;
		
	}

}
