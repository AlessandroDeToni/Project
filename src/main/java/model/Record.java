package model;

/**
 * classe che modella i record del dataset
 * @author Elia
 *
 */

public class Record{

	//oggetti freq, geo, unit, aid_instr/time_period 2000-2017
	//metodi per elenco attributi e tipo, dati json, statistiche sui dati(uso override)
		
		
		private String freq;
		private String geo;
		private String unit;
		private String instrtimeperiod;
		private double[] year  = new double[18]; 
		
		/**
		 * 
		 * @param freqin
		 * @param geoin
		 * @param unitin
		 * @param instrtimeperiodin
		 * @param yearin  è un array statico, dato che la dimensione in input sarà sampre costante
		 */
		public Record(String freqin, String geoin, String unitin, String instrtimeperiodin, double[] yearin) {
			
		this.freq=freqin;
		this.geo=geoin;
		this.unit=unitin;
		this.instrtimeperiod=instrtimeperiodin;
		System.arraycopy(yearin, 0, this.year, 0, 17);
			
		}
		/**
		 * definisco i metodi get per accedere alle variabili private
		 * 
		 */
		public String getFreq() {
			return this.freq;
		}
	    
		public String getGeo() {
			return this.geo;
		}
		
		public String getUnit() {
			return this.unit;
		}
		
		public String getInstrtimeperiod() {   
			return this.instrtimeperiod;
		}
		public double[] getYear() {
			return this.year;
		}
	}

	

