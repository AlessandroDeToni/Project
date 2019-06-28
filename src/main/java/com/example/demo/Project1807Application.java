package com.example.demo;

import java.io.*;
import java.net.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //configura l'occorrente per lanciare SpringBoot
public class Project1807Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1807Application.class, args); //lancia Spring
		
		try {
			BufferedInputStream inputStream = new BufferedInputStream(new URL("http://data.europa.eu/euodp/data/api/3/action/package_show?id=REmcPlVE1Wjrosy3cMhZbg").openStream());
		}
		catch (IOException e) {
				    System.out.println("Download fallito.");// handles IO exceptions
		}
	}
	
	
}
