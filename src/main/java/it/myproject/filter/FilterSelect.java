package it.myproject.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import it.myproject.models.lists.DataList;


public class FilterSelect {

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
		/*if (fieldName.startsWith("2")) {
			Double fieldNameD = Double.valueOf(fieldName);
			listaIn = new ArrayList<Object>(RichiestaUser.getCampo(src, fieldNameD));
		}
		else {
			listaIn = new ArrayList<Object>( RichiestaUser.getCampo(src, fieldName));
		}*/
		
		listaIn = FilterCheck.checkDoS(src, fieldName);
		
		
		int i = 0;
		
		for(Object item : listaIn) {
			
			try {             //cerca di risolvere il problema input
				
				if (operator.contentEquals(">") || operator.contentEquals("<") || operator.contentEquals("==")) {
					if(FilterCheck.checkConditional(item, operator, value))
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
		//Collection<Object> listaIn = RichiestaUser.getCampo(src, fieldName);
		Collection<Object> listaIn = FilterCheck.checkDoS(src, fieldName);
		
		int i = 0;
		
		for(Object item:listaIn) {
			try {        
				if (operator.contentEquals("and") || operator.contentEquals("or")) {
					if(FilterCheck.checkLogical(item, operator, value1, value2)) 
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
	 * overload di select per due campi diversi
	 * @param src lista di data che deve essere filtrata (Lista elaborata con la classe DataList)
	 * @param fieldName1 nome del primo campo su cui basare il filtraggio
	 * @param fieldName2 nome del secondo campo su cui basare il filtraggio
	 * @param operator operatore logico: "and", "or"
	 * @param value1 primo valore su cui basare la comparazione
	 * @param value2 secondo valore su cui basare la comparazione
	 * @return  lista di elementi filtrati secondo il criterio richiesto
	 */
	public static Collection<Object> Select (DataList src, String fieldName1, String fieldName2, String operator, Object value1, Object value2){

		Collection<Object> out = new ArrayList<Object>();
		Collection<Object> listaIn1 = FilterCheck.checkDoS(src, fieldName1);
		Collection<Object> listaIn2 = FilterCheck.checkDoS(src, fieldName2);
		
		Iterator<Object> listaIn1IT = listaIn1.iterator();
		Iterator<Object> listaIn2IT = listaIn2.iterator();
		
		int i = 0;
		
		while(listaIn1IT.hasNext() && listaIn2IT.hasNext()) {
			try {        
				if (operator.contentEquals("and") || operator.contentEquals("or")) {
					if(FilterCheck.checkLogical(listaIn1IT.next(), listaIn2IT.next(), operator, value1, value2)) 
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





