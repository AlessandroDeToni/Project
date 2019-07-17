package it.myproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import it.myproject.exceptions.EmptyListException;

/**
 * classe che si occupa di gestire le eccezioni lanciate dal controller
 * @author Alessandro
 *
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
	
	/** 
	 * Metodo che gestisce l'eccezione EmptyListException lanciata dal controller
	 * @param e
	 * @return messaggio che comunica che la lista è vuota
	 * 
	 * @see EmptyListException
	 */
	@ExceptionHandler (EmptyListException.class)
	public String handleEmptyList(EmptyListException e) {
		return e.getMessage();
	}
	
	/**
	 * Metodo che gestisce l'eccezione MissingServletRequestParameterException lanciata dal controller
	 * @param e
	 * @return messaggio che comunica che non hai inserito il parametro necessario per la richiesta
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException e) {
	    String name = e.getParameterName();
	    return("Errore! devi inserire il parametro: "+name);
	}
	
	/**
	 * Metodo che gestisce l'eccezione HttpRequestMethodNotSupportedException lanciata dal controller
	 * @param e
	 * @return messaggio che comunica che si è confuso GET con POST o viceversa nel fare la richiesta
	 */
	@ExceptionHandler (HttpRequestMethodNotSupportedException.class)
	public String handleWrongRequestMeth (HttpRequestMethodNotSupportedException e) {
		return("Errore! forse hai inserito la tipologia di richiesta sbagliata,\n"
				+ "controlla di non aver confuso GET con POST o viceversa.");
	}
	
	/**
	 * Metodo che gestisce l'eccezione MethodArgumentNotValidException lanciata dal controller
	 * @param e
	 * @return messaggio che comunica che il corpo della POST non è stato scritto correttamente
	 */
	
	@ExceptionHandler (HttpMessageNotReadableException.class) 
	@ResponseStatus (value = HttpStatus.BAD_REQUEST)
	public String handleWrongArguments (HttpMessageNotReadableException e) {
		return ("Errore! corpo della richiesta mancante");
	}
	
	

}
