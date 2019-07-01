package com.example.demo;
/**
 * libreria per leggere gli stream
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 * effettua il download del dataset all'avvio dell'applicazione
 * 
 * @author Elia

 */
public class DatasetDownloader {
	
	String url;
	String fileName;  
	
	/**
	 * costruttore della classe
	 * @param url  url del dataset
     * @param fileName  nome del file .csv che verrà creato
     * <p>
     * genero un oggetto di tipo stream{@link InputStream} per prendere in input i dati dalla connessione url{@link URL.openConnection#}
     * @throws Exception  
     * @throws IOException | ParseException  gestione problemi di parsing
     * commento da finire
	 */
	 DatasetDownloader(String url, String fileName){
	try {
		
		this.url = url;
		this.fileName = fileName;
		
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
			   System.out.println( line );
		   }
		 } finally {
		   in.close();
		 }
		JSONObject obj = (JSONObject) JSONValue.parseWithException(data); 
		JSONObject objI = (JSONObject) (obj.get("result"));
		JSONArray objA = (JSONArray) (objI.get("resources"));
		
		for(Object o: objA){
		    if ( o instanceof JSONObject ) {
		        JSONObject o1 = (JSONObject)o; 
		        String format = (String)o1.get("format");
		        String urlD = (String)o1.get("url");
		        System.out.println(format + " | " + urlD);
		        if(format.equals("http://publications.europa.eu/resource/authority/file-type/CSV")) {
		        	download(urlD, this.fileName);
		        }
		    }
		}
		System.out.println( "OK" );
	} catch (IOException | ParseException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}



public static void download(String url, String fileName) throws Exception {
   try (InputStream in = URI.create(url).toURL().openStream()) {
       Files.copy(in, Paths.get(fileName));
   }
}


}
