package it.myproject.models;

/**
 * classe che modella la POST per utilizzare i filtri
 * @author Alessandro
 *
 */
public class FilterReq {
    
	private String fieldname1;
	private String fieldname2;
	private String operator;
	private Object value1;
	private Object value2;
	
	/**
	 * costruttore della classe
	 * @param value1 primo valore su cui si basa la comparazione dei filtri
	 * @param value2 secondo valore su cui si basa la comparazione dei filtri
	 * @param fieldname1 campo di Record in cui cercare il primo valore
	 * @param fieldname2 campo di Record in cui cercare il secondo valore
	 * @param operator operatore richiesto per la comparazione: "and", "or", ">", "<", "=="
	 * 
	 * @see Record 
	 */
	public FilterReq(Object value1, Object value2, String fieldname1, String fieldname2, String operator) {
		
		this.fieldname1 = fieldname1;
		this.fieldname2 = fieldname2;
		this.operator = operator;
		this.value1 = value1;
		this.value2 = value2;
	}
	
	/**
	 * 
	 * @return value1
	 */
	public Object getValue1() {
		return value1;
	}

	/**
	 * 
	 * @return value2
	 */
	public Object getValue2() {
		return value2;
	}
	
	/**
	 * 
	 * @return fieldname1
	 */
	public String getFieldName1() {
		return fieldname1;
	}
	
	/**
	 * 
	 * @return fieldname2
	 */
	public String getFieldName2() {
		return fieldname2;
	}
	
	/**
	 * 
	 * @return operator
	 */
	public String getOperator() {
		return operator;
	}
	
	
}
