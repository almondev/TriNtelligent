/**
 * 
 */
package metier.decheterie;

/**
 * @author Mehdi HAMDI
 * Les déchetteries
 *
 */
public class EmplacementDechetterie extends Lieu {
	private String nomDechetterie;
	private Boolean ouvertWeekEnd;
	/**
	 * @param refLieu
	 * @param numero
	 * @param voie
	 * @param adresse
	 * @param complementAdresse
	 * @param commune
	 * @param lattitude
	 * @param longitude
	 * @param nomDechetterie
	 * @param ouvertWeekEnd
	 */
	public EmplacementDechetterie(int refLieu, int numero, Voie voie, String adresse, String complementAdresse,
			Commune commune, float lattitude, float longitude, String nomDechetterie, Boolean ouvertWeekEnd) {
		super(refLieu, numero, voie, adresse, complementAdresse, commune, lattitude, longitude);
		this.nomDechetterie = nomDechetterie;
		this.ouvertWeekEnd = ouvertWeekEnd;
	}
	
	
	
	
	/**
	 * @param numero
	 * @param voie
	 * @param adresse
	 * @param complementAdresse
	 * @param commune
	 * @param lattitude
	 * @param longitude
	 * @param nomDechetterie
	 * @param ouvertWeekEnd
	 */
	public EmplacementDechetterie(int numero, Voie voie, String adresse, String complementAdresse,
			Commune commune, float lattitude, float longitude, String nomDechetterie, Boolean ouvertWeekEnd) {
		super(numero, voie, adresse, complementAdresse, commune, lattitude, longitude);
		this.nomDechetterie = nomDechetterie;
		this.ouvertWeekEnd = ouvertWeekEnd;
	}




	/**
	 * @return the nomDechetterie
	 */
	public String getNomDechetterie() {
		return nomDechetterie;
	}
	/**
	 * @param nomDechetterie the nomDechetterie to set
	 */
	public void setNomDechetterie(String nomDechetterie) {
		this.nomDechetterie = nomDechetterie;
	}
	/**
	 * @return the ouvertWeekEnd
	 */
	public Boolean getOuvertWeekEnd() {
		return ouvertWeekEnd;
	}
	/**
	 * @param ouvertWeekEnd the ouvertWeekEnd to set
	 */
	public void setOuvertWeekEnd(Boolean ouvertWeekEnd) {
		this.ouvertWeekEnd = ouvertWeekEnd;
	}










}
