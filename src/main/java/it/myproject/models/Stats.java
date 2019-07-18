package it.myproject.models;

/**
 * classe che modella le statistiche eseguite sul campo selezionato in fase di richiesta
 * @author Alessandro
 *
 */
public class Stats {
	
	private int count;
	private double sum;
	private double avg;
	private double max;
	private double min;
	private double dev_std;
	
	/**
	 * costruttore
	 * @param count numero di elementi
	 * @param sum somma elementi
	 * @param avg media elementi
	 * @param max massimo degli elementi
	 * @param min minimo degli elementi
	 * @param dev_std deviazione standard degli elementi
	 */
	public Stats(int count, double sum, double avg, double max, double min, double dev_std) {
		this.count = count;
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.dev_std = dev_std;
	}
	
	/**
	 * 
	 * @return numero di elementi
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * 
	 * @return somma elementi
	 */
	public double getSum() {
		return sum;
	}
	
	/**
	 * 
	 * @return media elementi
	 */
	public double getAvg() {
		return avg;
	}
	
	/**
	 * 
	 * @return massimo degli elementi
	 */
	public double getMax() {
		return max;
	}
	
	/**
	 * 
	 * @return minimo degli elementi
	 */
	public double getMin() {
		return min;
	}
	
	/**
	 * 
	 * @return deviazione standard degli elementi
	 */
	public double getDev_std() {
		return dev_std;
	}

}
