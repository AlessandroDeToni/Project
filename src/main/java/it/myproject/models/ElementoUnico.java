package it.myproject.models;

/**
 * classe che modella un elemento che appartiene a uno dei campi del dataset
 * @author Alessandro
 *
 */
public class ElementoUnico {
	
	private int ripetizioni;
	private String elemento;

	public ElementoUnico(String elemento, int ripetizioni) {
		this.elemento = elemento;
		this.ripetizioni = ripetizioni;
	}

	public int getRipetizioni() {
		return this.ripetizioni;
	}

	public String getElemento() {
		return elemento;
	}
}
