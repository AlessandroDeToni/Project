package it.myproject.stats;

import java.util.ArrayList;

public class Sum implements ComputazioneDouble{
	public double calcolo(ArrayList<Double> campoIn) {
		double sum=0;
		for(double item : campoIn) {
			sum=sum+item;
		}
		return sum;	
	}
}