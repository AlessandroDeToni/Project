package it.myproject.models.lists;

import java.util.ArrayList;
import it.myproject.stats.*;

/**
 * interfaccia comune per le liste 
 * @see MetaDataList 
 * @see DataList 
 * @see ElementiUnici
 * @author Alessandro
 *
 */
public interface Lista {
	
	abstract public void creaLista(String filename);
	abstract public ArrayList getList();
	
}
