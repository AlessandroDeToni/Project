
package it.myproject.demoApplication;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.myproject.models.*;

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

