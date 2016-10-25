/**
 * 
 */
package metier.decheterie;

/**
 * @author Mehdi HAMDI
 *
 */
public class Fabricant {
	/**
	 * @return the nomFabricant
	 */
	private int idFabricant;
	private String nomFabricant;
	
	
	
	


	/**
	 * @param idFabricant
	 * @param nomFabricant
	 */
	public Fabricant(int idFabricant, String nomFabricant) {
		super();
		this.idFabricant = idFabricant;
		this.nomFabricant = nomFabricant;
	}

	public String getNomFabricant() {
		return nomFabricant;
	}

	/**
	 * @param nomFabricant the nomFabricant to set
	 */
	public void setNomFabricant(String nomFabricant) {
		this.nomFabricant = nomFabricant;
	}

	/**
	 * @return the idFabricant
	 */
	public int getIdFabricant() {
		return idFabricant;
	}

	/**
	 * @param idFabricant the idFabricant to set
	 */
	public void setIdFabricant(int idFabricant) {
		this.idFabricant = idFabricant;
	}


	
	
}
