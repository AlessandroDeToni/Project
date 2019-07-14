package it.myproject.stats;

import java.util.ArrayList;

/**
 * classe che calcola la media dei numeri contenuti in un ArrayList
 * @see ComputazioneDouble
 * 
 * @author Alessandro
 *
 */
public class Average implements ComputazioneDouble{
	
	/**
	 * 
	 * @param campoIn campo del dataset che si vuole studiare
	 * @return restitusce media dei numeri contenuti nel campo
	 */
	public static double calcolo(ArrayList<Double> campoIn) {
		
		double sum=0;
		double count=0;
		try{
			for(double item : campoIn) {
				sum=sum+item;
				count++;
			}
			return sum/count;}
		catch(ArithmeticException e) {
			{ 
				System.out.println("errore calcolo");
				e.printStackTrace();
			}

		}
		return 0;
	}
}
