/**
 * 
 */
package metier.decheterie;

/**
 * @author Mehdi HAMDI
 *
 */
public abstract class Lieu {
	//Constantes 
	
	//Variables
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
//	@Override
//	public String toString() {
//		return "Lieu [numero=" + numero + ", voie=" + voie.getNomVoie() + ", adresse=" + adresse + ", complementAdresse="
//				+ complementAdresse + ", Commune=" + Commune + ", lattitude=" + lattitude + ", longitude=" + longitude
//				+ "]";
//	}
	@Override
	public String toString() {
		return ""+refLieu+" : numero=" + numero + ", voie=" + voie.getNomVoie() + ", adresse=" + adresse + ", complementAdresse="
				+ complementAdresse + ", Commune=" + commune.getNomCommune() + ", lattitude=" + lattitude + ", longitude=" + longitude
				+ "]";
	}
	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @return the voie
	 */
	public Voie getVoie() {
		return voie;
	}
	/**
	 * @param voie the voie to set
	 */
	public void setVoie(Voie voie) {
		this.voie = voie;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the complementAdresse
	 */
	public String getComplementAdresse() {
		return complementAdresse;
	}
	/**
	 * @param complementAdresse the complementAdresse to set
	 */
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	/**
	 * @return the commune
	 */
	public Commune getCommune() {
		return commune;
	}

	/**
	 * @param commune the commune to set
	 */
	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	/**
	 * @return the lattitude
	 */
	public float getLattitude() {
		return lattitude;
	}
	/**
	 * @param lattitude the lattitude to set
	 */
	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}
	/**
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	private int		refLieu = 0;
	private int 	numero; // numéro de la voie
	private Voie 	voie;
	private String 	adresse;
	private String 	complementAdresse;
	private Commune commune;
	private float 	lattitude;
	private float 	longitude;


	/**
	 * @return the refLieu
	 */
	public int getRefLieu() {
		return refLieu;
	}
	/**
	 * @param refLieu the refLieu to set
	 */
	public void setRefLieu(int refLieu) {
		this.refLieu = refLieu;
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
	 */
	public Lieu(int refLieu, int numero, Voie voie, String adresse, String complementAdresse, Commune commune,
			float lattitude, float longitude) {
		super();
		this.refLieu = refLieu;
		this.numero = numero;
		this.voie = voie;
		this.adresse = adresse;
		this.complementAdresse = complementAdresse;
		this.commune = commune;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	/**

	 * @param numero
	 * @param voie
	 * @param adresse
	 * @param complementAdresse
	 * @param commune
	 * @param lattitude
	 * @param longitude
	 */
	public Lieu(int numero, Voie voie, String adresse, String complementAdresse, Commune commune,
			float lattitude, float longitude) {
		super();
		this.refLieu = 0;
		this.numero = numero;
		this.voie = voie;
		this.adresse = adresse;
		this.complementAdresse = complementAdresse;
		this.commune = commune;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}	
	
	
	
}
