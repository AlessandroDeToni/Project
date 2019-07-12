package model;

import java.util.ArrayList;
import java.util.Collection;

public class ElementiUnici extends RichiestaUser {

	public ElementiUnici(Lista in, String fieldName) {
		try {
			Collection<Object> campoIn=this.getCampo(in, fieldName);

			ArrayList<ElementoUnico> elementi=new ArrayList<>();

			for(Object item : campoIn) {
				for(ElementoUnico el: elementi) {
					if(el.getElemento()==(String)item) {
						el.aumRipetizioni();
					}
					else {
						elementi.add(new ElementoUnico((String)item, 1));
					}
				}	
			}
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();}
	}

}	