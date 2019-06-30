package com.example.demo;

import java.io.*;
import java.util.ArrayList;

public class DatasetModifier {
	
	ArrayList<String> lines = new ArrayList<String>();
    String line = null;
    
    public void  replaceComma() {

	 try {
		 
		 //inizializza gli oggetti per la lettura
         File f1 = new File("Euro.csv");
         FileReader fr = new FileReader(f1);
         BufferedReader br = new BufferedReader(fr);
         
         //legge il file e sostituisce virgole con punti e virgola
         while ((line = br.readLine()) != null)
         {
             if (line.contains(","))
                 line = line.replace(",", ";");
             lines.add(line);
         }
         
         fr.close();
         br.close();
         
         //scrive il nuovo file
         FileWriter fw = new FileWriter(f1);
         BufferedWriter out = new BufferedWriter(fw);
         for(String s : lines) {
          
        	 out.write(s);
        	 out.newLine();
         }
         
         out.flush();
         out.close();
	 
	 } catch (Exception e) {
         e.printStackTrace(); //segnala cosa ha causato l'errore e in che punto del codice
     }
 }
}
