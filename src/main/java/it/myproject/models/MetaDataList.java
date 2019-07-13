package it.myproject.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Classe che gestisce una lista di metadati
 * @author Alessandro
 *
 */
public class MetaDataList {
	
	private ArrayList<MetaData> md;
	
	public MetaDataList() {}
	
	/**
	 * Crea una lista di metadati presi dalla classe Record e dal dataset
	 * @see Record
	 * @param filename nome del file che contiene il dataset
	 */
	public void creaLista(String filename) {
		try {
			
			md = new ArrayList<MetaData>();
			
			File f =new File(filename); 
			BufferedReader in = new BufferedReader(new FileReader(f));
			String line = in.readLine(); //leggo la prima linea per ottenere i sourceFields 
			
			Field[] fields = Record.class.getDeclaredFields(); //inserisci le variabili di Record in un array di Field
			int i = 0;
			for (String s : line.split(";")) {
				
				if (i >= 4) { //gestisce l'ultimo campo (è un array)
					String type = fields[4].getType().getComponentType().getName();
					String alias = fields[4].getName()+"["+(i-4)+"]"; //restituisce componente per componente il campo year
					md.add(new MetaData(type,alias,s));
					i++;
					
				}
				else {
				String alias = fields[i].getName(); //prende l'alias del campo corrispondente
				String type = fields[i].getType().getSimpleName(); //prende il nome del tipo del campo corrispondente
				md.add(new MetaData(type,alias,s)); //costruisce la lista di metadati
				i++;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @return restituisce la lista di metadati
	 */
	public ArrayList<MetaData> getList(){
		return this.md;
	}
}
