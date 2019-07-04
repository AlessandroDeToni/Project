
package com.example.demo;
import model.Record;

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
        ArrayList<Record> records = new ArrayList<Record>();
//TODO al posto di queste cose ci va la lista di record che si riempie in automatico leggendo dal file
        
        double[] year1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.5, 4.4, 0, 0.2, 0.2, 0, 0};
        double[] year2 = {0, 0, 0, 0.1, 0.1, 17.8, 0.4, 0.5, 0.5, 0.4, 0.5, 7.4, 0.8, 0.6, 0.5, 0.5, 0.3, 7.5};
        Record r1 = new Record("A", "IT", "PC_TOT", "EQUIT", year1);
        Record r2 = new Record("A", "FR", "PC_TOT", "EQUIT", year2);
        
        
        records.add(r1);
        records.add(r2);
        
        return records;
    }
}

