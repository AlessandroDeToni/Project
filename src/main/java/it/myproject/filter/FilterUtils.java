package it.myproject.filter;

import java.util.ArrayList;
import java.util.Collection;

import it.myproject.models.RichiestaUser;
import it.myproject.models.lists.DataList;


//TODO test "and" e "or", aggiungere nel select di and e or la possibilità di inserire due campi diversi

public class FilterUtils {

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


	/**
	 * 
	 * @param src Lista di data che deve essere filtrata (Lista elaborata con la classe DataList)
	 * @param fieldName nome del campo su cui basare il filtraggio
	 * @param operator operatore condizionale: "<", ">", "=="
	 * @param value valore su cui basare la comparazione
	 * @return lista di elementi filtrati secondo il criterio richiesto
	 * 
	 * @see DataList
	 */
	public static Collection<Object> Select (DataList src, String fieldName, String operator, Object value){ 	//collection<Object> è la classe base per una collezione generica

		Collection<Object> out = new ArrayList<Object>();
		Collection<Object> listaIn;
		
		//la seguente parte di codice discerne tra getCampo per Stringhe o Double
		if (fieldName.startsWith("2")) {
			Double fieldNameD = Double.valueOf(fieldName);
			listaIn = new ArrayList<Object>(RichiestaUser.getCampo(src, fieldNameD));
		}
		else {
			listaIn = new ArrayList<Object>( RichiestaUser.getCampo(src, fieldName));
		}
		
		
		int i = 0;
		
		for(Object item : listaIn) {
			
			try {             //cerca di risolvere il problema input
				
				if (operator.contentEquals(">") || operator.contentEquals("<") || operator.contentEquals("==")) {
					if(FilterUtils.checkConditional(item, operator, value))
						out.add(src.getList().get(i));
				}
			}
			catch (RuntimeException e) {
				e.printStackTrace();
			} 
			i++; //aggiorna l'indice con cui prelevare i record
		}
		return out;
	}

	/**
	 * 
	 * @param src lista di data che deve essere filtrata (Lista elaborata con la classe DataList)
	 * @param fieldName nome del campo su cui basare il filtraggio
	 * @param operator operatore logico: "and", "or"
	 * @param value1  primo valore su cui basare la comparazione
	 * @param value2  secondo valore su cui basare la comparazione
	 * @return lista di elementi filtrati secondo il criterio richiesto
	 * 
	 * @see DataList
	 */
	public static Collection<Object> Select (DataList src, String fieldName, String operator, Object value1, Object value2){

		Collection<Object> out = new ArrayList<Object>();
		Collection<Object> listaIn = RichiestaUser.getCampo(src, fieldName);
		
		int i = 0;
		
		for(Object item:listaIn) {
			try {        
				if (operator.contentEquals("and") || operator.contentEquals("or")) {
					if(FilterUtils.checkLogical(item, operator, value1, value2)) 
						out.add(src.getList().get(i));	
				}
			}
			catch (RuntimeException e) {
				e.printStackTrace();
			}
			i++; //aggiorna l'indice con cui prelevare i record
		}
		return out;
	}
}





