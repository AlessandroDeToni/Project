package it.myproject.models;

/**
 * Classe che modella i metadati del dataset
 * @author Alessandro
 *
 */
public class MetaData {

	private String type;
	private String alias;
	private String sourceField;
	
	/**
	 * 
	 * @param type tipo del campo 
	 * @param alias nome con cui il campo viene chiamato nel programma
	 * @param sourceField nome con cui il campo è chiamato nel dataset
	 */
	public MetaData(String type, String alias, String sourceField) {
		
		this.type = type;
		this.alias = alias;
		this.sourceField = sourceField;
	}
	

	public String getType() {
		return type;
	}

	public String getAlias() {
		return alias;
	}

	public String getSourceField() {
		return sourceField;
	}
	
	

}
