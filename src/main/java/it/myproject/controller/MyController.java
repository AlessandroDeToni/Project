
package it.myproject.controller;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.myproject.filter.FilterSelect;
import it.myproject.models.*;
import it.myproject.models.lists.DataList;
import it.myproject.models.lists.MetaDataList;
import it.myproject.stats.*;

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
	@RequestMapping(value = "/Data", method = RequestMethod.GET)
	public ArrayList<Record> retrieveAllRecords() {

		
		DataList Mylist = new DataList();
		Mylist.creaLista("Euro.csv"); //crea la lista leggendo dal file

		return Mylist.getList();
	}
	
	/**
	 * metodo che risponde alla richiesta di visione dei metadati della lista.
	 * 
	 * @return viene restituita la lista di metadati in formato JSON.
	 */
	@RequestMapping(value = "/MetaData", method = RequestMethod.GET)
	public ArrayList<MetaData> retrieveMetadata () {
		
		MetaDataList mList = new MetaDataList();
		mList.creaLista("Euro.csv");
		return mList.getList();
	}
	
	/**
	 * metodo che risponde alla richiesta di visione degli elementi unici della lista.
	 * @param fieldname Stringa rappresentante uno dei campi Stringa del dataset: "freq", "geo", "unit", "instrtimeperiod".
	 * @return viene restituita la lista di elementi unici con le rispettive occorrenze.
	 */
	@RequestMapping(value = "/ElementiUnici", method = RequestMethod.GET)
	public ArrayList<ElementoUnico> elemCounter (@RequestParam(name = "fieldname") String fieldname) {
		
		DataList Mylist = new DataList();
		Mylist.creaLista("Euro.csv"); //crea la lista leggendo dal file
		
		ElementiUnici el = new ElementiUnici(Mylist);
		el.creaLista(fieldname);
		return el.getList();
	} 
	
	/**
	 * metodo che risponde alla richiesta di visione delle statistiche sugli elementi numerici della lista.
	 * 
	 * @param fieldname anno (numero compreso tra 2000 e 2017) su cui si vogliono ottenere le statistiche.
	 * @return vengono restituite statiste riguardati: somma, media, minimo, massimo, deviazione standard.
	 */
	@RequestMapping(value = "/Stats", method = RequestMethod.GET)
	public Stats statistiche (@RequestParam(name = "fieldname") Double fieldname) {
		
		DataList Mylist = new DataList();
		Mylist.creaLista("Euro.csv"); //crea la lista leggendo dal file
		ArrayList<Double> campoIn = RichiestaUser.getCampo(Mylist, fieldname);
	
		
		//calcolo delle statistiche:
		int count = (campoIn.size());
		double sum = Sum.calcolo(campoIn);
		double avg = Average.calcolo(campoIn);
		double max = Max.calcolo(campoIn);
		double min = Min.calcolo(campoIn);
		double dev_std = DevStd.calcolo(campoIn);
		

		Stats s = new Stats(count, sum, avg, max, min, dev_std);
		return s;
	} 
	
	/**
	 * 
	 * @param req oggetto della classe FilterReq che modella la POST
	 * @return lista filtrata secondo il criterio scelto.
	 * 
	 * @see FilterReq
	 */
	@PostMapping(path = "/Filter") 
	public Collection<Object> filterList (@RequestBody FilterReq req) {

		DataList MyList = new DataList();
		MyList.creaLista("Euro.csv");

		/*se l'operatore inserito è condizionale viene eseguito il codice all'interno dell' if,
		altrimenti viene restituita la lista filtrata dagli operatori logici*/
		if (req.getValue2()==null) {
			return FilterSelect.Select(MyList, req.getFieldName1(), req.getOperator(), req.getValue1());
		} else if(req.getFieldName2()==null) {
			return FilterSelect.Select(MyList, req.getFieldName1(), req.getOperator(), req.getValue1(), req.getValue2());	
		}
		return FilterSelect.Select(MyList, req.getFieldName1(), req.getFieldName2(), req.getOperator(), req.getValue1(), req.getValue2());
	}
}
