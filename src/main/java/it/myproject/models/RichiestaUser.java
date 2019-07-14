package it.myproject.models;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import it.myproject.models.lists.DataList;
import it.myproject.models.lists.*;

/**
 * Classe che permette di ottenere una collection di oggetti relativi al campo richiesto dall'utente
 * 
 * @author Alessandro
 *
 */
public class RichiestaUser {
	
	/**
	 * 
	 * @param in Lista in ingresso
	 * @param fieldName nome del campo di cui si vuole una collection
	 * @return Restituisce una collection di oggetti facenti parte del campo del dataset selezionato.
	 */
	public static Collection<Object> getCampo(DataList in, String fieldName) {
		
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
	
	//overload di getCampo per i double 
	public static ArrayList<Double> getCampo(DataList in, Double fieldName) {
		
		ArrayList<Double> out = new ArrayList<Double>();
		
		for(Object record :in.getList()) {
			try{
				
				//crea un metodo get 
				Method m = record.getClass().getMethod("getSpecYear", int.class); 
				try {
					Double campo = (Double)m.invoke(record, fieldName.intValue());
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
