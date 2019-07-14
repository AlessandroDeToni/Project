package it.myproject.stats;

import java.util.ArrayList;

public class Sum implements ComputazioneDouble{
	public double calcolo(ArrayList<Double> campoIn) {
		double sum=0;
		try {
			for(double item : campoIn) {
				sum=sum+item;
			}	
		}
		catch(ArithmeticException e) {
			System.out.println("errore calcolo");
			e.printStackTrace();
		}
		return sum;
	}
}