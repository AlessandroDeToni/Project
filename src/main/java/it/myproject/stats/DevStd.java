package it.myproject.stats;

import java.util.ArrayList;

/**
 * classe che calcola la deviazione standard dei numeri continuiti in un ArrayList
 * @see ComputazioneDouble
 * 
 * @author Alessandro
 *
 */
public class DevStd implements ComputazioneDouble{
	
	/**
	 * 
	 * @param campoIn campo del dataset che si vuole studiare
	 * @return restituisce la deviazione standard degli elementi contenuti nel campo
	 */
	public static double calcolo(ArrayList<Double> campoIn) {
		
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
