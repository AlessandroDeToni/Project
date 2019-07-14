package it.myproject.stats;

import java.util.ArrayList;

public class Max {
	public double calcolo(ArrayList<Double> campoIn) {
		double max=0;
		try {
			for(double item : campoIn) {
				if(max<item) {
					max=item;
				}
			}
		}
		catch(ArithmeticException e) {
			System.out.println("errore calcolo");
			e.printStackTrace();
		}
		return max;
	}
}