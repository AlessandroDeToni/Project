package it.myproject.demoApplication;


import java.io.IOException;

import org.json.simple.parser.ParseException;
/**
/ * libreria di Springboot
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.myproject.down_pars_modify.DatasetDownloader;
import it.myproject.down_pars_modify.DatasetModifier;

@SpringBootApplication  
/**
 * Costituisce la classe principale del progetto:
 * 1) esegue il download del dataset e rimpiazza le "," con ";" per facilitare la trasposizione del dataset in una lista 
 * 2) lancia spring
 * 
 * @author Alessandro
 *
 */
public class Project1807Application {

	public static void main(String[] args) {


		//esegue il download del dataset
		DatasetDownloader downloader = new DatasetDownloader ("http://data.europa.eu/euodp/data/api/3/action/package_show?"
				+ "id=REmcPlVE1Wjrosy3cMhZbg", "Euro.csv");


		// trasforma le virgole in ";" in modo da facilitare l'immissione in lista del file scaricato
		DatasetModifier dm = new DatasetModifier();
		dm.replaceComma(); 
		/**
		 * lancia Spring
		 * <p>
		 * @param Project1807Application.class  prima classe instanziata nel processo dell'applicazione 
		 * @param args
		 */
		SpringApplication.run(Project1807Application.class, args); 
	}

}		


