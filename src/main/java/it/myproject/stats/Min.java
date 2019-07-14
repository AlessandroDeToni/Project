package it.myproject.stats;

import java.util.ArrayList;

public class Min {
	public double calcolo(ArrayList<Double> campoIn) {
		double min=0;
		try{
			for(double item : campoIn) {
				if(min>item) {
					min=item;
				}
			}
		}
		catch(ArithmeticException e) {
			System.out.println("errore calcolo");
			e.printStackTrace();
		}
		return min;
	}

}
