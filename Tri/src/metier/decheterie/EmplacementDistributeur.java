/**
 * 
 */
package metier.decheterie;

/**
 * @author Mehdi HAMDI
 *
 */
public class EmplacementDistributeur extends Lieu{
	/**
	 * @return the nomDistributeur
	 */
	
	/**
	 * 
	 */
	private String nomDistributeur;
	
	public String getNomDistributeur() {
		return nomDistributeur;
	}

	/**
	 * @param nomDistributeur the nomDistributeur to set
	 */
	public void setNomDistributeur(String nomDistributeur) {
		this.nomDistributeur = nomDistributeur;
	}

	/**
	 * @param refLieu
	 * @param numero
	 * @param voie
	 * @param adresse
	 * @param complementAdresse
	 * @param commune
	 * @param lattitude
	 * @param longitude
	 * @param nomDistributeur
	 */
	public EmplacementDistributeur(int refLieu, int numero, Voie voie, String adresse, String complementAdresse,
			Commune commune, float lattitude, float longitude, String nomDistributeur) {
		super(refLieu, numero, voie, adresse, complementAdresse, commune, lattitude, longitude);
		this.nomDistributeur = nomDistributeur;
	}

	/**
	 * @param numero
	 * @param voie
	 * @param adresse
	 * @param complementAdresse
	 * @param commune
	 * @param lattitude
	 * @param longitude
	 * @param nomDistributeur
	 */
	public EmplacementDistributeur(int numero, Voie voie, String adresse, String complementAdresse,
			Commune commune, float lattitude, float longitude, String nomDistributeur) {
		super(numero, voie, adresse, complementAdresse, commune, lattitude, longitude);
		this.nomDistributeur = nomDistributeur;
	}







	
	
}
