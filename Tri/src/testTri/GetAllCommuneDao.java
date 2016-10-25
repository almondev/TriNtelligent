/**
 * 
 */
package testTri;

import java.util.List;

import dao.CommuneDao;
import metier.decheterie.Commune;

/**
 * @author Afpa
 *
 */
public class GetAllCommuneDao {

	/**
	 * 
	 */
	public GetAllCommuneDao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommuneDao cDao = new CommuneDao();
		List<Commune> listCommune =cDao.getAll();
		
		for(Commune c : listCommune){
			System.out.println(c.getNomCommune());
		}
		
	}

}
