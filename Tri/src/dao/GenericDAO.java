/**
 * 
 */
package dao;


import java.sql.SQLException;
import java.util.List;

import parametres.ConnectionOracle;

/**
 * @author Afpa
 *
 */
public interface GenericDAO<E> {
	public void 	saveOrUpdate(E entite);
    public 			List<E> getAll();
    public 			E get(int id);
    public void 	add(E entity);
    public void 	update(E entity);
    public void 	remove(E entity);
    public void 	removeAll();
    public 			List<E> search(String champ);
    public int 		taille();   
    public 			E getEChamp (String champ);
    public 			int getIndex (String champ);   
    
}
