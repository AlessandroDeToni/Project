package com.example.demo;

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

public class DatasetDownloader {
	
	String url; //conterrà l'url del dataset
	String fileName; //rappresenta il nome del file .csv che verrà creato
	
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
