package it.myproject.stats;

import java.util.ArrayList;

public class Max {
	
	public static double calcolo(ArrayList<Double> campoIn) {
		
		double max=0;
		
		for(double item : campoIn) {
			if(max<item) {
				max=item;
			}
		}
		return max;
	}
}