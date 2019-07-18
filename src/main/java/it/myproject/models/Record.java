package it.myproject.models;

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
		 * @param freq campo FREQ dataset
		 * @param geo campo GEO dataset
		 * @param unit campo UNIT dataset
		 * @param instrtimeperiod campo AID_INSTR/TIMEPERIOD dataset
		 * @param yearin è un array statico, dato che la dimensione in input sarà sampre costante
		 */
		public Record(String freq, String geo, String unit, String instrtimeperiod, double[] yearin) {
			
		this.freq=freq;
		this.geo=geo;
		this.unit=unit;
		this.instrtimeperiod=instrtimeperiod;
		System.arraycopy(yearin, 0, this.year, 0, 18);
			
		}
		
		/**
		 *@return restituisce il membro freq 
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
		/**
		 * overload del metodo, restituisce l'oggetto Double dell'anno specificato
		 * @param year array contenenti i campi anno del dataset
		 * @return l'array contenente tutti gli anni
		 */
		public Double getYear(int year) {
			return (Double)this.year[year];
		}
		
		/**
		 * 
		 * @param i specifico cercato scritto come usa normalmente
		 * @return l'anno cercato
		 */
		public double getSpecYear(int i) {
			i = i-2000;
			return this.year[i];
		}
	}

	

