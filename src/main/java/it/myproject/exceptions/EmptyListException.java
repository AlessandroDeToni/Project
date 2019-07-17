package it.myproject.exceptions;

/**
 * eccezione da lanciare in caso di lista vuota
 * @author Alessandro
 *
 */
public class EmptyListException extends Exception {
	
	/**
	 * crea un eccezione da lanciare se la lista è vuota.
	 * @param message messaggio che si vuole inviare al mittente
	 */
	public EmptyListException(String message) {
		super(message);
	}
}
