package com.example.demo;


//librerie per SpringBoot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //configura l'occorrente per lanciare SpringBoot
public class Project1807Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1807Application.class, args); //lancia Spring
		
		//mi occupo del download dei dati usando la classe DatasetDownload
		
		DatasetDownloader downloader = new DatasetDownloader ("http://data.europa.eu/euodp/data/api/3/action/package_show?"
				+ "id=REmcPlVE1Wjrosy3cMhZbg", "Euro.csv");

	
	}		
}
	
