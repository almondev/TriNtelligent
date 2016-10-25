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
public class Colonne extends Collecteur {
	
	//Méthodes
	@Override
	public boolean remplaceCeCollecteur(Collecteur col){
		boolean estRemplacable = false;
		return estRemplacable;
		
	}
	private boolean estInsonorise;		// la colonne est ell insonorisé?
	private boolean estEnterree;		// la colonne est elle enterré?
	private int nbPortes;				// nombre de portes de la colonne
	@Override
	public boolean repareCollecteur() {
		// TODO Auto-generated method stub
		return false;
	}

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
	 * @param estInsonorise
	 * @param estEnterree
	 * @param nbPortes
	 */
	public Colonne(String nomCollecteur, Produit produit, LocalDate dateCreation,
			LocalDate dateMiseAJour, LocalDate dateSuppression, String nomFabricant, String referenceFabricant,
			Lieu emplacement, String etatCollecteur, boolean estSurSite, boolean estInsonorise, boolean estEnterree,
			int nbPortes) {
		super(nomCollecteur, produit, dateCreation, dateMiseAJour, dateSuppression, nomFabricant,
				referenceFabricant, emplacement, etatCollecteur, estSurSite);
		this.estInsonorise = estInsonorise;
		this.estEnterree = estEnterree;
		this.nbPortes = nbPortes;
	}

	/**
	 * @return the estInsonorise
	 */
	public boolean isEstInsonorise() {
		return estInsonorise;
	}
	/**
	 * @param estInsonorise the estInsonorise to set
	 */
	public void setEstInsonorise(boolean estInsonorise) {
		this.estInsonorise = estInsonorise;
	}
	/**
	 * @return the estEnterree
	 */
	public boolean isEstEnterree() {
		return estEnterree;
	}
	/**
	 * @param estEnterree the estEnterree to set
	 */
	public void setEstEnterree(boolean estEnterree) {
		this.estEnterree = estEnterree;
	}
	/**
	 * @return the nbPortes
	 */
	public int getNbPortes() {
		return nbPortes;
	}
	/**
	 * @param nbPortes the nbPortes to set
	 */
	public void setNbPortes(int nbPortes) {
		this.nbPortes = nbPortes;
	}

	






	
	
	
	
}
