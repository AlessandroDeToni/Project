package it.myproject.down_pars_modify;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 * classe che effettua il download del dataset all'avvio dell'applicazione
 * 
 * @author Alessandro

 */



public class DatasetDownloader {
	
	/**
	 * effettua il download del dataset all'avvio dell'applicazione
	 * @param url  url del dataset
     * @param fileName  nome del file .csv che verrà creato
     * <p>
     * genero un oggetto di tipo stream per prendere in input i dati dalla connessione url
     * @see InputStream
	 */
	public static void downloader (String url, String fileName){
		try {
			
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Google Chrome");
			InputStream in = openConnection.getInputStream();
			
			 String data = "";
			 String line = "";
			
			 try {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buf = new BufferedReader( inR );
			  
			   while ( ( line = buf.readLine() ) != null ) {
				   data+= line;
			   }
			 } finally {
			   in.close();
			 }
			JSONObject obj_tot = (JSONObject) JSONValue.parseWithException(data); //esegue il parsing del JSON in un oggetto
			JSONObject objR = (JSONObject) (obj_tot.get("result")); 			  //cerca "result" nel JSON parsato e lo inserisce in objR
			JSONArray objA = (JSONArray) (objR.get("resources")); 			      //cerca le "resources" all'interno delle graffe di "result" contenuto in objR e lo inserisce in objA
			
			for(Object ob: objA){ 											//scorre objA
			    if ( ob instanceof JSONObject ) { 
			        JSONObject ob1 = (JSONObject)ob; 				
			        String format = (String)ob1.get("format"); 				//inserisce il valore del campo format all'interno di format
			        URL url_todownload = new URL((String)ob1.get("url"));	//fa lo stesso ma con l'url corrispondente
			        
			        if(format.equals("http://publications.europa.eu/resource/authority/file-type/CSV")) //questo è il format che vogliamo per il download
			        	{  
			        		File f = new File(fileName); 
			        		FileUtils.copyURLToFile(url_todownload, f, 10000, 10000); /*esegue il download del file: se è già esistente lo sovrascrive, altrimenti ne crea uno nuovo.
			        																	i due parametri finali stabiliscono i millisecondi che il metodo copyURLtoFile attenderà se:
			        																	1) non riesce a stabilire nessuna connessione con la sorgente del file
			        																	2) non riesce a leggere dati dalla sorgente del file*/
			        		System.out.println("Download eseguito!");
			        	}
			        }
			    }
				}catch (UnknownHostException e) {
					System.out.println("controllare di essere connessi a internet prima di lanciare l'applicazione.");
				} 
				catch (IOException | ParseException e) {
						e.printStackTrace(); //gestisce i problemi di input/output e di parsing
				} catch (Exception e) {
						e.printStackTrace();
				}
		}
}
	

