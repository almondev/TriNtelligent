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
public class Meuble extends Collecteur {

	private int nombreCompartiments;
	

	

	




	/**
	 * @param nomCollecteur
	 * @param produit
	 * @param dateCreation
	 * @param dateMiseAJour
	 * @param dateSuppression
	 * @param nomFabricant
	 * @param referenceFabricant
	 * @param emplacement
	 * @param etatCollecteur
	 * @param estSurSite
	 * @param nombreCompartiments
	 */
	public Meuble(String nomCollecteur, Produit produit, LocalDate dateCreation,
			LocalDate dateMiseAJour, LocalDate dateSuppression, String nomFabricant, String referenceFabricant,
			Lieu emplacement, String etatCollecteur, boolean estSurSite, int nombreCompartiments) {
		super(nomCollecteur, produit, dateCreation, dateMiseAJour, dateSuppression, nomFabricant,
				referenceFabricant, emplacement, etatCollecteur, estSurSite);
		this.nombreCompartiments = nombreCompartiments;
	}









	@Override
	public boolean repareCollecteur() {
		// TODO Auto-generated method stub
		return false;
	}

}
