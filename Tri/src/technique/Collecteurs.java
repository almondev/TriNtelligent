/**
 * 
 */
package technique;

import java.time.LocalDate;
import java.util.ArrayList;
import metier.decheterie.Colonne;
import metier.decheterie.Lieu;
import metier.decheterie.Meuble;
import metier.decheterie.Produit;
import metier.decheterie.Boite;
import metier.decheterie.Collecteur;
import metier.decheterie.Sac;

/**
 * @author Mehdi HAMDI
 * @param <E>
 *
 */
public class Collecteurs extends ArrayList<Collecteur> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Ajoute uncollecteur	
	public boolean addCollecteur(Collecteur typeCollecteur, String nomCollecteur, Produit produit, LocalDate dateCreation,
			LocalDate dateMiseAJour, String nomFabricant, String referenceFabricant,
			Lieu emplacement, String etatCollecteur, boolean estSurSite, boolean estInsonorise, boolean estEnterree,
			int nbPortes){
		if (typeCollecteur instanceof Colonne) {
			try {
				Colonne new_colonne = (Colonne) typeCollecteur;	
				new_colonne.setNomCollecteur(nomCollecteur);
				new_colonne.setProduit(produit);
				new_colonne.setDateCreation(dateCreation);
				new_colonne.setDateMiseAJour(dateMiseAJour);
				LocalDate ldnull = null;
				new_colonne.setDateSuppression(ldnull);
				new_colonne.setNomFabricant(nomFabricant);
				new_colonne.setReferenceFabricant(referenceFabricant);
				new_colonne.setEmplacement(emplacement);
				new_colonne.setEtatCollecteur(etatCollecteur);
				new_colonne.setEstSurSite(estSurSite);
				new_colonne.setEstInsonorise(estInsonorise);
				new_colonne.setEstEnterree(estEnterree);
				boolean add = add(new_colonne);
				return add;
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		} else if (typeCollecteur instanceof Meuble){
			Meuble new_Meuble = (Meuble) typeCollecteur;
		} else if (typeCollecteur instanceof Sac) {
			Sac new_Sac = (Sac)  typeCollecteur;
		} else {
			Boite new_Boite = (Boite)  typeCollecteur;
		}
		
		return false;
	}

}
