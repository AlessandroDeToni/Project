package it.myproject.stats;

import java.util.ArrayList;

public class DevStd {
	public double calcolo(ArrayList<Double> campoIn) {
		double lenght=campoIn.size();
		double somma=0;
		double sommaQuad=0;
		try {
			for(double item : campoIn) {
				somma=somma+item;
				sommaQuad=sommaQuad+Math.pow(item, 2);
			}
			return (sommaQuad-Math.pow(somma, 2)/lenght)/(lenght-1);
		}
		catch(ArithmeticException e) { 
			System.out.println("errore calcolo");
			e.printStackTrace();
		}
		return 0;
	}
}
