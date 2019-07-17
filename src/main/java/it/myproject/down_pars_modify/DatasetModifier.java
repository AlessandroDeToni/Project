package it.myproject.down_pars_modify;

import java.io.*;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Sostituisce le virgole contenute nel Dataset scaricato con dei ";"
 * 
 * @author Alessandro
 *
 */

public class DatasetModifier {

	
	/**
	 *  Sostituisce le virgole contenute nel Dataset scaricato con dei ";"
	 */
	public static void replaceComma() {

		try {
			
			//inizializza gli oggetti per la lettura
			File f1 = new File("Euro.csv");
			FileReader fr = new FileReader(f1);
			
			BufferedReader br = new BufferedReader(fr); //crea br come flusso di dati derivati dal file

			ArrayList<String> lines = new ArrayList<String>();
			String line = null;

			//legge il file e sostituisce virgole con punti e virgola

			while ((line = br.readLine()) != null) //inserisce le righe lette dal file in line
			{
				if (line.contains(","))
					line = line.replace(",", ";");  //esegue lo scamio, virgola->punto e virgola
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

		} catch (FileNotFoundException e) {
			System.out.println("il file non è presente nella cartella.\n");
		}
		catch (UnknownHostException e) {
			System.out.println("controllare di essere connessi a internet prima di lanciare l'applicazione.");
		}
		catch (Exception e) {
			e.printStackTrace(); //segnala cosa ha causato l'errore e in che punto del codice
		}	
	}
}
