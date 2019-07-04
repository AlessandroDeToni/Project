package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lista {

		private String line;
		private ArrayList<Record> data = new ArrayList<>(); //lista
		private BufferedReader in;
		
		public Lista() {}
		
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
				data.add(new Record(stringarr[0], stringarr[1], stringarr[2], stringarr[3], k ));
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

}		
		







