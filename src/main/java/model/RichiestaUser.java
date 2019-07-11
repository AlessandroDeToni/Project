package model;
import java.awt.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;



public class RichiestaUser {
//controllare se non legge la prima riga
	public Collection<Object> getCampo(Lista in, String fieldName) {
		Collection<Object> out = new ArrayList<Object>();
		for(Object record :in.getList()) {
			try{
				
		       Method m = record.getClass().getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);
		       try {
		          Object campo= m.invoke(record);
		          out.add(campo); 
		       }
		       catch(IllegalAccessException e) {
				e.printStackTrace();
			   }
			   catch (IllegalArgumentException e) {
				e.printStackTrace();
			   } catch (InvocationTargetException e) {
				e.printStackTrace();
			   }
			}
			catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}	
		}
		return out;
	} 		
}
