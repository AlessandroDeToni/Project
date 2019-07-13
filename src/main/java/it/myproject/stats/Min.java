package it.myproject.stats;

import java.util.ArrayList;

public class Min {
	public double calcolo(ArrayList<Double> campoIn) {
		double min=0;
		for(double item : campoIn) {
			if(min>item) {
				min=item;
			}
		}
		return min;
	}

}
