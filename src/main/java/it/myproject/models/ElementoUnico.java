package it.myproject.models;

public class ElementoUnico {
	private String elemento;
	private int ripetizioni;

	public ElementoUnico(String elementoIn, int ripetizioniIn) {
		this.elemento=elementoIn;
		this.ripetizioni=ripetizioniIn;
	}

	public void setElemento(String elementoIn) {
		this.elemento=elementoIn;
	}

	public String getElemento() {
		return this.elemento;
	}

	public void aumRipetizioni() {
		this.ripetizioni++;
	}

	public int getRipetizioni() {
		return this.ripetizioni;
	}
}
