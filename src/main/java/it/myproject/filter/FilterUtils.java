package it.myproject.filter;

import java.util.ArrayList;
import java.util.Collection;

import it.myproject.models.Lista;
import it.myproject.models.RichiestaUser;



public class FilterUtils {

	//per l'array di double, passo l'oggetto Double preso da double[i]
	public static boolean checkConditional(Object value, String operator, Object th) {
		try {
			if(th instanceof Double && value instanceof Double) {
				double thC = ((Double)th).doubleValue();
				double valueC = ((Double)value).doubleValue();
				if(operator.contentEquals("==")) {
					return value.equals(th);       //devo togliere == e metterci <
				}
				else if(operator.contentEquals(">")) {
					return valueC>thC;
				}
			}	
			else if(th instanceof String && value instanceof String && operator=="==") {
				return value==th;
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("argomento non valido/n");
		}
		return false;
	}




	public static boolean checkLogical(Object field, String operator, Object request1, Object request2) {
		//farlo anche per la lista di double, con un ovveride
		if (operator.contentEquals("or")) {
			return (field.equals(request1) || field.equals(request2));
		}
		else if (operator.contentEquals("and")) {
			return (field.equals(request1) && field.equals(request2));
		}
		return false;
	}	//devo metterci un try/catch per evitare che i parametri siano di tipi diversi


	//collection<T> è la classe base per una collezione generica
	public Collection<Object> Select (Lista src, String fieldName, String operator, Object value){

		Collection<Object> out = new ArrayList<Object>();
		Collection<Object> listaIn = RichiestaUser.getCampo(src, fieldName);

		for(Object item:listaIn) {
			//serve a prendere la prima lettera della stringa e renderla maiuscola, poi ci aggiunge il restante della stringa in
			//modo da prendere il metodo specificato in ingresso "get*****"


			//Method m = item.getClass().getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);
			try {             //cerca di risolvere il problema input
				//Object tmp = m.invoke(item);

				if (operator.contentEquals(">") || operator.contentEquals("<")) {
					if(FilterUtils.checkConditional(item, operator, value))
						out.add(item);
				}
			}
			catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}					
		}
		return out;
	}



	//devo fare un getyear per prendere i double dell'anno richiesto

	public Collection<Object> Select (Lista src, String fieldName, String operator, Object value1, Object value2){

		Collection<Object> out = new ArrayList<Object>();
		Collection<Object> listaIn = RichiestaUser.getCampo(src, fieldName);

		for(Object item:listaIn) {
			try {        
				if (operator.contentEquals("and") || operator.contentEquals("or")) {
					if(FilterUtils.checkLogical(item, operator, value1, value2)) 
						out.add(item);	
				}
			}
			catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}					
		}
		return out;
	}
}





