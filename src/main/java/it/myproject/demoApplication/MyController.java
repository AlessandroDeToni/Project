
package it.myproject.demoApplication;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.myproject.models.*;
import it.myproject.models.lists.DataList;
import it.myproject.models.lists.MetaDataList;
import it.myproject.stats.ElementiUnici;

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

		DataList Mylist = new DataList();
		Mylist.creaLista("Euro.csv"); //crea la lista leggendo dal file

		return Mylist.getList();
	}
	
	@RequestMapping(value = "/MetaDati", method = RequestMethod.GET)
	public ArrayList<MetaData> retrieveMetadata () {
		
		MetaDataList mList = new MetaDataList();
		mList.creaLista("Euro.csv");
		return mList.getList();
	}
	
	@RequestMapping(value = "/ElementiUnici", method = RequestMethod.GET)
	public ArrayList<ElementoUnico> elemCounter (@RequestParam(name = "fieldname") String fieldname) {
		
		DataList Mylist = new DataList();
		Mylist.creaLista("Euro.csv"); //crea la lista leggendo dal file
		
		ElementiUnici el = new ElementiUnici(Mylist);
		el.creaLista(fieldname);
		return el.getList();
	} 
	
}
