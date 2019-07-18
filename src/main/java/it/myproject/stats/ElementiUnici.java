package it.myproject.stats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import it.myproject.models.ElementoUnico;
import it.myproject.models.RichiestaUser;
import it.myproject.models.lists.DataList;
import it.myproject.models.lists.Lista;

/**
 * 
 * classe utilizzata per contare elementi unici: tramite il costruttore è possibile creare una lista di Oggetti "Elemento Unico".
 * @see ElementoUnico
 * 
 * @author Alessandro
 *
 */
public class ElementiUnici implements Lista{
	
	private ArrayList<ElementoUnico> elementi;
	private DataList in;
	
	
	public ElementiUnici(DataList in) {
		this.in = in;
	}
	
	/**
	 * 
	 *
	 * @param fieldName nome del file di cui si vuole creare una lista
	 * 
	 * Crea una lista di oggetti "ElementoUnico"
	 * @see ElementoUnico
	 */
	public void creaLista (String fieldName) {
		try {

			Collection<Object> campoIn = RichiestaUser.getCampo(in, fieldName); //contiene la lista di elementi appartenenti al campo scelto

			elementi = new ArrayList<>();
			HashSet<Object> noDupl = new HashSet<Object>(); // creo un set in cui inserirò gli elementi(che per proprietà dell'HashSet saranno unici)

			for(Object item : campoIn) {

				noDupl.add(item); //inserisce gli elementi nel set
			}


			for (Object item : noDupl) {

				int occurencies = Collections.frequency(campoIn, item); //conta quante volte l'elemento (identificato con item) è presente in CampoIn
				ElementoUnico el = new ElementoUnico((String)item, occurencies);
				elementi.add(el);

			}	

		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @return Array di oggetti ElementoUnico, cioé un array contenente gli elementi che compaiono nel data set e le rispettive occorrenze
	 */
	public ArrayList<ElementoUnico> getList() {
		return this.elementi;
	}
	

}