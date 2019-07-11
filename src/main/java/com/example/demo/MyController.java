
package com.example.demo;
import model.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * classe che controlla il flusso dei dati
 * @author Alessandro 
 * 
 */
public class MyController {

	/**
	 * metodo che risponde alla richiesta di visione totale della lista.
	 * 
	 * @return viene restituita la lista comprendente tutti i dati del file in formato JSON.
	 */
	@RequestMapping(value = "/ViewAllList", method = RequestMethod.GET)
	public ArrayList<Record> retrieveAllRecords() {

		Lista Mylist = new Lista();
		Mylist.creaLista("Euro.csv"); //crea la lista leggendo dal file

		return Mylist.getList();
	}
}

