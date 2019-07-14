package it.myproject.stats;

import java.util.ArrayList;

/**
 * classe che calcola il massimo dei numeri contenuti in un ArrayList
 * @see ComputazioneDouble
 * 
 * @author Alessandro
 *
 */
public class Max implements ComputazioneDouble{
	
	/**
	 * 
	 * @param campoIn campo del dataset che si vuole studiare
	 * @return restituisce il massimo numero contenuto nel campo
	 */
	public static double calcolo(ArrayList<Double> campoIn) {
		
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