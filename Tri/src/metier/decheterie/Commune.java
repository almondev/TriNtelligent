/**
 * 
 */
package metier.decheterie;

/**
 * @author Mehdi HAMDI
 *
 */
public class Commune {
	
	
	


	/**
	 * @return the idCommune
	 */
	public int getIdCommune() {
		return idCommune;
	}

	/**
	 * @param idCommune the idCommune to set
	 */
	public void setIdCommune(int idCommune) {
		this.idCommune = idCommune;
	}

	/**
	 * @return the nomCommune
	 */
	public String getNomCommune() {
		return nomCommune;
	}

	/**
	 * @param nomCommune the nomCommune to set
	 */
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	private int idCommune;
	private String nomCommune;

	/**
	 * @param nomCommune
	 * @param idCommune
	 */
	public Commune(int idCommune, String nomCommune) {
		super();
		this.nomCommune = nomCommune;
		this.idCommune = idCommune;
	}


	
	
}
