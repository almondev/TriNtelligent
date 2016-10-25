/**
 * 
 */
package metier.decheterie;

/**
 * @author Mehdi HAMDI
 * catalogue fabicant des collecteurs avec leur référence
 */
public class RefFabricant {
	
	// Getters et Setters
	/**
	 * @return the nombreRef
	 */
	public static int getNombreRef() {
		return nombreRef;
	}
	/**
	 * @param nombreRef the nombreRef to set
	 */
	public static void setNombreRef(int nombreRef) {
		RefFabricant.nombreRef = nombreRef;
	}
	/**
	 * @return the instanceCollecteur
	 */
	public Collecteur getInstanceCollecteur() {
		return instanceCollecteur;
	}
	/**
	 * @param instanceCollecteur the instanceCollecteur to set
	 */
	public void setInstanceCollecteur(Collecteur instanceCollecteur) {
		this.instanceCollecteur = instanceCollecteur;
	}
	/**
	 * @return the codeFabricant
	 */
	public String getCodeFabricant() {
		return codeFabricant;
	}
	/**
	 * @param codeFabricant the codeFabricant to set
	 */
	public void setCodeFabricant(String codeFabricant) {
		this.codeFabricant = codeFabricant;
	}
	/**
	 * @return the descriptionFabricant
	 */
	public String getDescriptionFabricant() {
		return descriptionFabricant;
	}
	/**
	 * @param descriptionFabricant the descriptionFabricant to set
	 */
	public void setDescriptionFabricant(String descriptionFabricant) {
		this.descriptionFabricant = descriptionFabricant;
	}
	/**
	 * @return the fabricant
	 */
	public String getFabricant() {
		return fabricant;
	}
	/**
	 * @param fabricant the fabricant to set
	 */
	public void setFabricant(String fabricant) {
		this.fabricant = fabricant;
	}
	/**
	 * @return the picCollecteurFabricant
	 */
	public String getPicCollecteurFabricant() {
		return picCollecteurFabricant;
	}
	/**
	 * @param picCollecteurFabricant the picCollecteurFabricant to set
	 */
	public void setPicCollecteurFabricant(String picCollecteurFabricant) {
		this.picCollecteurFabricant = picCollecteurFabricant;
	}
	
	
	// Constructeurs :	
	/**
	 * 
	 */
	public RefFabricant() {
		super();
		this.nombreRef++;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param instanceCollecteur
	 * @param codeFabricant
	 * @param descriptionFabricant
	 * @param fabricant
	 */
	public RefFabricant(Collecteur instanceCollecteur, String codeFabricant, String descriptionFabricant,
			String fabricant) {
		super();
		this.nombreRef++;
		this.instanceCollecteur = instanceCollecteur;
		this.codeFabricant = codeFabricant;
		this.descriptionFabricant = descriptionFabricant;
		this.fabricant = fabricant;
	}
	/**
	 * Seulement les deux paramètres obligatoires
	 * @param instanceCollecteur
	 * @param codeFabricant
	 */
	public RefFabricant(Collecteur instanceCollecteur, String codeFabricant) {
		super();
		this.nombreRef++;
		this.instanceCollecteur = instanceCollecteur;
		this.codeFabricant = codeFabricant;
	}



	
	/**
	 * @param instanceCollecteur
	 * @param codeFabricant
	 * @param descriptionFabricant
	 * @param fabricant
	 * @param picCollecteurFabricant
	 */
	public RefFabricant(Collecteur instanceCollecteur, String codeFabricant, String descriptionFabricant,
			String fabricant, String picCollecteurFabricant) {
		super();
		this.instanceCollecteur = instanceCollecteur;
		this.codeFabricant = codeFabricant;
		this.descriptionFabricant = descriptionFabricant;
		this.fabricant = fabricant;
		this.picCollecteurFabricant = picCollecteurFabricant;
	}




	private static int nombreRef = 0;
	private Collecteur instanceCollecteur;					// (obligatoire) pour connaitre le type de collecteur (Colonne, Boite
	private String codeFabricant;							//
	private String descriptionFabricant;					// (optionnel) description du collecteur
	private String fabricant;								// (optionnel)
	private String picCollecteurFabricant;


	
	

	
}
