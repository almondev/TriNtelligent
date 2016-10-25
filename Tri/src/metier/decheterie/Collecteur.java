/**
 * 
 */
package metier.decheterie;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Mehdi HAMDI
 * La classe Collecteur ne dois pas être instancié
 */
public abstract class Collecteur {

	/**
	 * @return the nomFabricant
	 */
	public String getNomFabricant() {
		return nomFabricant;
	}



	/**
	 * @param nomFabricant the nomFabricant to set
	 */
	public void setNomFabricant(String nomFabricant) {
		this.nomFabricant = nomFabricant;
	}



	// Getters et Setters des paramètres :
	/**
	 * @return the nomCollecteur
	 */
	public String getNomCollecteur() {
		return nomCollecteur;
	}



	/**
	 * @param nomCollecteur the nomCollecteur to set
	 */
	public void setNomCollecteur(String nomCollecteur) {
		this.nomCollecteur = nomCollecteur;
	}



	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}



	/**
	 * @param produit the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}



	/**
	 * @return the dateCreation
	 */
	public LocalDate getDateCreation() {
		return dateCreation;
	}



	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}



	/**
	 * @return the dateMiseAJour
	 */
	public LocalDate getDateMiseAJour() {
		return dateMiseAJour;
	}



	/**
	 * @param dateMiseAJour the dateMiseAJour to set
	 */
	public void setDateMiseAJour(LocalDate dateMiseAJour) {
		this.dateMiseAJour = dateMiseAJour;
	}



	/**
	 * @return the dateSuppression
	 */
	public LocalDate getDateSuppression() {
		return dateSuppression;
	}



	/**
	 * @param dateSuppression the dateSuppression to set
	 */
	public void setDateSuppression(LocalDate dateSuppression) {
		this.dateSuppression = dateSuppression;
	}







	/**
	 * @return the referenceFabricant
	 */
	public String getReferenceFabricant() {
		return nomFabricant;
	}



	/**
	 * @param referenceFabricant the referenceFabricant to set
	 */
	public void setReferenceFabricant(String referenceFabricant) {
		this.nomFabricant = referenceFabricant;
	}



	/**
	 * @return the emplacement
	 */
	public Lieu getEmplacement() {
		return emplacement;
	}



	/**
	 * @param emplacement the emplacement to set
	 */
	public void setEmplacement(Lieu emplacement) {
		this.emplacement = emplacement;
	}



	/**
	 * @return the etatCollecteur
	 */
	public String getEtatCollecteur() {
		return etatCollecteur;
	}



	/**
	 * @param etatCollecteur the etatCollecteur to set
	 */
	public void setEtatCollecteur(String etatCollecteur) {
		this.etatCollecteur = etatCollecteur;
	}



	/**
	 * @return the estSurSite
	 */
	public boolean isEstSurSite() {
		return estSurSite;
	}



	/**
	 * @param estSurSite the estSurSite to set
	 */
	public void setEstSurSite(boolean estSurSite) {
		this.estSurSite = estSurSite;
	}



	/**
	 * @return the etat
	 */
	public static String[] getEtat() {
		return ETAT;
	}



	/**
	 * @return the typeCollecteur
	 */
	public String getTypeCollecteur() {
		return typeCollecteur;
	}



	/**
	 * @param typeCollecteur the typeCollecteur to set
	 */
	public void setTypeCollecteur(String typeCollecteur) {
		this.typeCollecteur = typeCollecteur;
	}



	// Méthodes
	public abstract boolean repareCollecteur();

	public boolean remplaceCeCollecteur(Collecteur collecteur){
		boolean estRemplacable = false;
		return estRemplacable;
		
	}
	
	/**
	 * @param nomCollecteur
	 * @param produit
	 * @param dateCreation
	 * @param dateMiseAJour
	 * @param dateSuppression
	 * @param indexRefFabricant
	 * @param referenceFabricant
	 * @param emplacement
	 * @param etatCollecteur
	 * @param estSurSite
	 */
	public Collecteur(String nomCollecteur, Produit produit, LocalDate dateCreation,
			LocalDate dateMiseAJour, LocalDate dateSuppression, String nomFabricant, String referenceFabricant,
			Lieu emplacement, String etatCollecteur, boolean estSurSite) {
		super();
		this.nomCollecteur = nomCollecteur;
		this.produit = produit;
		this.dateCreation = dateCreation;
		this.dateMiseAJour = dateMiseAJour;
		this.dateSuppression = dateSuppression;
		this.nomFabricant = nomFabricant;
		this.referenceFabricant = referenceFabricant;
		this.emplacement = emplacement;
		this.etatCollecteur = etatCollecteur;
		this.estSurSite = estSurSite;
	}

	// Constantes
	public final static String [] ETAT = {"neuf", "abimé", "en réparation", "perdu", "au rebut"};
	// Variables :
	private String 			nomCollecteur;					// nom du collecteur	une fois créé il ne peut être modifié générér automatique											(obligatoire)
	private Produit			produit;						// type déchet sous forme de Produit									(obligatoire)
	private String			typeCollecteur;					// type de collecteur
	private LocalDate		dateCreation;					// date de création du collecteur									(obligatoire)
	private LocalDate		dateMiseAJour;					// date d'actualisation
	private LocalDate		dateSuppression;				// date de suppression du collecteur
	private String				nomFabricant;					// nom du fabricant du collection Listing fabricant
	private String			referenceFabricant;				// référence du fabricant du collecteur								(obligatoire)
	private Lieu			emplacement;					// affectation de l'emplacement du collecteur pour le recyclage		(obligatoire) 
	private String			etatCollecteur;					// valeur de la constante ETAT à l'index  indexETATCollecteur : il y a 5 valeurs possibles
	private boolean			estSurSite;							// permet de savoir si le collecteur est sur le site; sinon il est en réparation ou supprimé
	//Constructeurs


	
	
	







	

	


}
