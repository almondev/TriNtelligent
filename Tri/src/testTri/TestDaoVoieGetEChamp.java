/**
 * 
 */
package testTri;

import java.util.ArrayList;
import java.util.List;

import dao.VoieDAO;
import metier.decheterie.Voie;


/**
 * @author Afpa
 *
 */
public class TestDaoVoieGetEChamp {

	/**
	 * 
	 */
	public TestDaoVoieGetEChamp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// recupère toutes les voies
		VoieDAO vDao = new VoieDAO();
		List<Voie> voies =  (ArrayList<Voie>) vDao.getAll();
		for(Voie v : voies){
			System.out.println(v.getNomVoie());
		}

		// Liste une voie avec un champ 'Ancien chemin'
		String champNomVoie="Ancien chemin";
		Voie uneVoie = vDao.getEChamp(champNomVoie);
		System.out.println("voie : "+uneVoie.getNomVoie());
		
		
	}

}
