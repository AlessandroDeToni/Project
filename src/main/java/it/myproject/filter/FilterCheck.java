package it.myproject.filter;

import java.util.ArrayList;

import it.myproject.models.RichiestaUser;
import it.myproject.models.lists.DataList;

public class FilterCheck {

	/**
	 * 
	 * @param value oggetto che va comparato al valore "value" tramite l'operatore selezionato
	 * @param operator operatore condizionale: "<", ">", "=="
	 * @param th "threshold": (soglia) valore con cui eseguire la comparazione/filtraggio
	 * @return restituisce vero o falso a seconda del fatto che la condizione sia soddisfatta
	 */
	public static boolean checkConditional(Object value, String operator, Object th) {
		try {
			
			if((th instanceof Number) && (value instanceof Double)) { //usando Number anche se viene riportato in input 0, 
				double thD = ((Number)th).doubleValue();			  //viene cercato 0.0 (che è come è rappresentato in lista)
				double valueD = ((Double)value).doubleValue();
				if(operator.contentEquals("==")) {
					return valueD==thD;
				}
				else if(operator.contentEquals(">")) {
					return valueD>thD;
				}
				else if(operator.contentEquals("<")) {
					return valueD<thD;
				}
			}	
			else if((th instanceof String) && (value instanceof String) && (operator.contentEquals("=="))) {
				return value.equals(th);
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("argomento non valido/n");
			e.printStackTrace();
		}
		return false;
	}



	/**
	 * 
	 * @param field campo della classe Record che va comparato ai valori richiesti
	 * @param operator operatore logico: "and" o "or"
	 * @param request1 primo valore con cui eseguire la comparazione
	 * @param request2 secondo valore con cui eseguire la comparazione
	 * @return restituisce vero o falso a seconda del fatto che la condizione sia soddisfatta
	 */
	public static boolean checkLogical(Object field, String operator, Object request1, Object request2) {

		try {
			if (operator.contentEquals("or")) {
				return (field.equals(request1) || field.equals(request2));
			}
			else if (operator.contentEquals("and")) {
				return (field.equals(request1) && field.equals(request2));
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("argomento non valido/n");
			e.printStackTrace();
		}
		return false;
	}	
	
	public static boolean checkLogical(Object field1, Object field2, String operator, Object request1, Object request2) {

		try {
			if (operator.contentEquals("or")) {
				return (field1.equals(request1) || field2.equals(request2));
			}
			else if (operator.contentEquals("and")) {
				return (field1.equals(request1) && field2.equals(request2));
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("argomento non valido/n");
			e.printStackTrace();
		}
		return false;
	}	
	
	/**
	 * Valuta se 
	 * @param src
	 * @param fieldName
	 * @return
	 */
	public static ArrayList<Object> checkDoS (DataList src, String fieldName) {
		if (fieldName.startsWith("2")) {
			Double fieldNameD = Double.valueOf(fieldName);
			return new ArrayList<Object>(RichiestaUser.getCampo(src, fieldNameD));
		}
		else {
			return new ArrayList<Object>( RichiestaUser.getCampo(src, fieldName));
		}
	}
	
}
