package it.myproject.models;

public class FilterReq {

	private String fieldname1;
	private String fieldname2;
	private String operator;
	private Object value1;
	private Object value2;
	
	
	public FilterReq(Object value1, Object value2, String fieldname1, String fieldname2, String operator) {
		
		this.fieldname1 = fieldname1;
		this.fieldname2 = fieldname2;
		this.operator = operator;
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public Object getValue1() {
		return value1;
	}

	public Object getValue2() {
		return value2;
	}

	public String getFieldName1() {
		return fieldname1;
	}
	
	public String getFieldName2() {
		return fieldname2;
	}
	public String getOperator() {
		return operator;
	}
	
	
}
