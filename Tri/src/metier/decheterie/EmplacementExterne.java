package metier.decheterie;

public class EmplacementExterne extends Lieu {
	private int nombreMaxCollecteurs;	// nombre maximum de collecteur sur la voie	
	
	/**
	 * @return the nombreMaxCollecteurs
	 */
	public int getNombreMaxCollecteurs() {
		return nombreMaxCollecteurs;
	}

	/**
	 * @param nombreMaxCollecteurs the nombreMaxCollecteurs to set
	 */
	public void setNombreMaxCollecteurs(int nombreMaxCollecteurs) {
		this.nombreMaxCollecteurs = nombreMaxCollecteurs;
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
	 * @param nombreMaxCollecteurs
	 */
	public EmplacementExterne(int refLieu, int numero, Voie voie, String adresse, String complementAdresse,
			Commune commune, float lattitude, float longitude, int nombreMaxCollecteurs) {
		super(refLieu, numero, voie, adresse, complementAdresse, commune, lattitude, longitude);
		this.nombreMaxCollecteurs = nombreMaxCollecteurs;
	}

	/**
	 * @param numero
	 * @param voie
	 * @param adresse
	 * @param complementAdresse
	 * @param commune
	 * @param lattitude
	 * @param longitude
	 * @param nombreMaxCollecteurs
	 */
	public EmplacementExterne(int numero, Voie voie, String adresse, String complementAdresse,
			Commune commune, float lattitude, float longitude, int nombreMaxCollecteurs) {
		super(numero, voie, adresse, complementAdresse, commune, lattitude, longitude);
		this.nombreMaxCollecteurs = nombreMaxCollecteurs;
	}









	




	
	
	
}
