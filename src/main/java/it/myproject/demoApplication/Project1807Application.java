package it.myproject.demoApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import it.myproject.down_pars_modify.DatasetDownloader;
import it.myproject.down_pars_modify.DatasetModifier;

/**
 * Costituisce la classe principale del progetto:
 * 1) esegue il download del dataset e rimpiazza le "," con ";" per facilitare la trasposizione del dataset in una lista 
 * 2) lancia spring
 * 
 * @author Alessandro
 *
 */
@SpringBootApplication 
@ComponentScan({"it.myproject.controller"}) //serve per comunicare a springboot che il controller è in un package diverso
public class Project1807Application {

	public static void main(String[] args) {


		//esegue il download del dataset
		DatasetDownloader.downloader ("http://data.europa.eu/euodp/data/api/3/action/package_show?"
				+ "id=REmcPlVE1Wjrosy3cMhZbg", "Euro.csv");


		// trasforma le virgole in ";" in modo da facilitare l'immissione in lista del file scaricato
		DatasetModifier.replaceComma(); 
		
		/**
		 * lancia Spring
		 * <p>
		 * @param Project1807Application.class prima classe contenente il main del progetto
		 * @param args
		 */
		SpringApplication.run(Project1807Application.class, args); 
	}

}		


