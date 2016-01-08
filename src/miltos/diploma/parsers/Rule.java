package miltos.diploma.parsers;

/**
 * A class that represents a PMD Rule.
 * 
 * @author Miltos Siavvas
 *
 */
public class Rule {
	
	/* One field for each attribute found in the xml file */
	private String name;
	private String language;
	private String since;
	private String message;
	private String clazz;
	private String externalInfoUrl;
	private String description;
	private int priority;
	
	/**
	 * Setters ...
	 * 
	 */
	public void setName(String name){
		this.name = name;
	}
	
	public void setLanguage(String language){
		this.language = language;
	}
	
	public void setSince(String since){
		this.since = since;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public void setClazz(String clazz){
		this.clazz = clazz;
	}
	
	public void seteExternalInfoUrl(String externalInfoUrl){
		this.externalInfoUrl = externalInfoUrl;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	/**
	 * Getters...
	 * 
	 */
	public String getName(){
		return this.name;
	}
	
	public String getExternalInfoUrl(){
		return this.externalInfoUrl;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public String getSince(){
		return this.since;
	}
	
	public String getLanguage(){
		return this.language;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String getClazz(){
		return this.clazz;
	}
	
	
	public int getPriority(){
		return this.priority;
	}
	

}
