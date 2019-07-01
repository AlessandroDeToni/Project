package com.example.demo;


/**
/ * libreria di Springboot
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  
/**
 * configura l'occorrente per lanciare SpringBoot
 * 
 * @author Elia
 *
 */
public class Project1807Application {

	public static void main(String[] args) {
		/**
		 * lancia Spring
		 * <p>
		 * @param Project1807Application.class  prima classe instanziata nel processo dell'applicazione 
		 * @param args
		 */
		SpringApplication.run(Project1807Application.class, args); 
		/**
		 * mi occupo del download dei dati 
		 * <p> 
		 * uso la classe DatasetDownloader:{link@DatasetDownloader}
		 * @see <a href="http://data.europa.eu/euodp/data/api/3/action/package_show?">
		 */
		DatasetDownloader downloader = new DatasetDownloader ("http://data.europa.eu/euodp/data/api/3/action/package_show?"
				+ "id=REmcPlVE1Wjrosy3cMhZbg", "Euro.csv");
		
		//trasforma le virgole in ";" in modo da facilitare l'immissione in lista del file scaricato
				DatasetModifier dm = new DatasetModifier();
				dm.replaceComma(); 

	
	}		
}
	
