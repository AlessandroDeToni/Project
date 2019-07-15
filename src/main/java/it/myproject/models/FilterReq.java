package it.myproject.models;

public class FilterReq {

	private String fieldname;
	private String operator;
	private Object value1;
	private Object value2;
	
	
	public FilterReq(Object value1, Object value2,String fieldname, String operator) {
		
		this.fieldname = fieldname;
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

	public String getFieldName() {
		return fieldname;
	}
	public String getOperator() {
		return operator;
	}
	
	
}
