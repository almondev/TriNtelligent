/**
 * 
 */
package metier.decheterie;

import java.awt.Color;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Mehdi HAMDI
 *
 */
public class Sac extends Collecteur {

	private Color couleur;
	
	

	

	





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
	 * @param couleur
	 */
	public Sac(String nomCollecteur, Produit produit, LocalDate dateCreation,
			LocalDate dateMiseAJour, LocalDate dateSuppression, String nomFabricant, String referenceFabricant,
			Lieu emplacement, String etatCollecteur, boolean estSurSite, Color couleur) {
		super(nomCollecteur, produit, dateCreation, dateMiseAJour, dateSuppression, nomFabricant,
				referenceFabricant, emplacement, etatCollecteur, estSurSite);
		this.couleur = couleur;
	}











	@Override
	public boolean repareCollecteur() {
		// TODO Auto-generated method stub
		return false;
	}



}
