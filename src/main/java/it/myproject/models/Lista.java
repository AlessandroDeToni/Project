package it.myproject.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * classe che crea una lista leggendo i dati dal file scaricato
 * 
 * @author Alessandro
 *
 */
public class Lista {

	private String line;
	private ArrayList<Record> data = new ArrayList<>(); //lista
	private BufferedReader in;

	public Lista() {}

	/**
	 * creaLista prende in input il nome del file da cui vogliamo leggere i dati e li inserisce in una lista
	 * di oggetti del tipo Record (chiaramente i campi del file devono essere concordi con quelli della classe Record).
	 * 
	 * @param filename
	 */
	public void creaLista(String filename) {
		File f =new File(filename);   //da passare al buffer
		try {
			in = new BufferedReader(new FileReader(f));
			//devo scartare la prima linea, faccio un controllo
			if((line=in.readLine())!=null) {  //scarto la prima riga del file
				while((line=in.readLine())!=null) {  //fa un controllo mentre legge il file
					String[] stringarr=line.split(";");
					double[] k =new double[18];
					for(int j=4, counter=0; j<21 || counter<18; j++, counter++) {
						k[counter]=java.lang.Double.valueOf(stringarr[j]);
					}
					this.data.add(new Record(stringarr[0], stringarr[1], stringarr[2], stringarr[3], k )); //riempie il membro "data" della classe Lista
				}	
			}

			else {
				System.out.println();
			}
		}
		catch(IOException i) {
			System.out.println();

		}

	}

	/**
	 * 
	 * @return restituisce la lista di oggetti Record
	 */
	public ArrayList<Record> getList (){ 
		return this.data;
	}

}		








