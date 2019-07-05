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
		 * metodi get per accedere alle variabili private
		 * 
		 */
		public String getFreq() {
			return this.freq;
		}
	    
		/**
	     * @return restituisce il membro geo
	     */
		public String getGeo() {
			return this.geo;
		}
		 
		/** 
	     * @return restituisce il membro unit
	     */
		public String getUnit() {
			return this.unit;
		}
		
		/** 
	     * @return restituisce il membro Instrtimeperiod
	     */
		public String getInstrtimeperiod() {   
			return this.instrtimeperiod;
		}
		
		/** 
	     * @return restituisce il membro year
	     */
		public double[] getYear() {
			return this.year;
		}
	}

	

