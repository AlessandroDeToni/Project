package it.myproject.models;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;



public class RichiestaUser {
	
	/**
	 * 
	 * @param in Lista in ingresso
	 * @param fieldName nome del campo di cui si vuole una collection
	 * @return Restituisce una collection di oggetti facenti parte del campo del dataset selezionato.
	 */
	public static Collection<Object> getCampo(Lista in, String fieldName) {
		
		Collection<Object> out = new ArrayList<Object>();
		
		for(Object record :in.getList()) {
			try{
				
				//crea un metodo get 
				Method m = record.getClass().getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null); 
				try {
					Object campo = m.invoke(record);
					out.add(campo); 
				}
				catch(IllegalAccessException e) {
					e.printStackTrace();
				}
				catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}	
		}
		return out;
	} 		
}
