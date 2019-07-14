package it.myproject.stats;

import java.util.ArrayList;

/**
 * classe che calcola il minimo dei numeri contenuti in un ArrayList
 * @see ComputazioneDouble
 * 
 * @author Alessandro
 *
 */

public class Min implements ComputazioneDouble {
	
	/**
	 * 
	 * @param campoIn campo del dataset che si vuole studiare
	 * @return restituisce il minimo numero contenuto nel campo
	 */
	public static double calcolo(ArrayList<Double> campoIn) {
		
		double min=0;
		
		for(double item : campoIn) {
			if(min>item) {
				min=item;
			}
		}
		return min;
	}

}
