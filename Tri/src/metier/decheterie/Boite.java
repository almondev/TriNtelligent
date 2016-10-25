/**
 * 
 */
package metier.decheterie;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Mehdi HAMDI
 *
 */
public class Boite extends Collecteur {


	private int epaisseurBoite;
	




	/**
	 * @param nomCollecteur
	 * @param produit
	 * @param typeCollecteur
	 * @param dateCreation
	 * @param dateMiseAJour
	 * @param dateSuppression
	 * @param nomFabricant
	 * @param referenceFabricant
	 * @param emplacement
	 * @param etatCollecteur
	 * @param estSurSite
	 * @param epaisseurBoite
	 */
	public Boite(String nomCollecteur, Produit produit, LocalDate dateCreation,
			LocalDate dateMiseAJour, LocalDate dateSuppression, String nomFabricant, String referenceFabricant,
			Lieu emplacement, String etatCollecteur, boolean estSurSite, int epaisseurBoite) {
		super(nomCollecteur, produit, dateCreation, dateMiseAJour, dateSuppression, nomFabricant,
				referenceFabricant, emplacement, etatCollecteur, estSurSite);
		this.epaisseurBoite = epaisseurBoite;
	}









































	@Override
	public boolean repareCollecteur() {
		// TODO Auto-generated method stub
		return false;
	}

}
