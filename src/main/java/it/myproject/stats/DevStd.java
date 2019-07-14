package it.myproject.stats;

import java.util.ArrayList;

public class DevStd {
	
	public static double calcolo(ArrayList<Double> campoIn) {
		
		double lenght=campoIn.size();
		double somma=0;
		double sommaQuad=0;
		
		for(double item : campoIn) {
			somma=somma+item;
			sommaQuad=sommaQuad+Math.pow(item, 2);
		}
		return (sommaQuad-Math.pow(somma, 2)/lenght)/(lenght-1);
	}
}
