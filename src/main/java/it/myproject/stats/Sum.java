package it.myproject.stats;

import java.util.ArrayList;

/**
 * classe che calcola la somma dei numeri contenuti in un ArrayList
 * @see ComputazioneDouble
 * 
 * @author Alessandro
 *
 */
public class Sum implements ComputazioneDouble{
	
	/**
	 * 
	 * @param campoIn campo del dataset che si vuole studiare
	 * @return restituisce la somma dei numeri contenuto nel campo
	 */
	public static double calcolo(ArrayList<Double> campoIn) {
		
		double sum=0;
		
		for(double item : campoIn) {
			sum=sum+item;
		}
		return sum;	
	}
}