package it.myproject.stats;

import java.util.ArrayList;

public class Average {
	public double calcolo(ArrayList<Double> campoIn) {
		double sum=0;
		double count=0;
		for(double item : campoIn) {
			sum=sum+item;
			count++;
		}
		return sum/count;
	}
}
