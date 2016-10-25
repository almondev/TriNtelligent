/**
 * 
 */
package metier.decheterie;

/**
 * @author Mehdi HAMDI
 *
 */
public class Produit {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produit [nomProduit=" + nomProduit + "]";
	}

	/**
	 * @return the nomProduit
	 */
	public String getNomProduit() {
		return nomProduit;
	}

	/**
	 * @param nomProduit the nomProduit to set
	 */
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	
	





	/**
	 * @return the idProduit
	 */
	public int getIdProduit() {
		return idProduit;
	}

	/**
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}






	private int idProduit;
	private String nomProduit;

	/**
	 * @param nomProduit
	 * @param idProduit
	 */
	public Produit(int id, String ProduitnomProduit ) {
		super();
		this.nomProduit = nomProduit;
		this.idProduit = idProduit;
	}



	
	
	
}
