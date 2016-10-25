/**
 * 
 */
package metier.decheterie;

import java.io.Serializable;

/**
 * @author Mehdi HAMDI
 *
 */
public class Voie implements Serializable {
	private int id;
	private String abreviation;
	private String nomVoie;



	/**
	 * @param id
	 * @param abreviation
	 * @param nomVoie
	 */
	public Voie(int id, String abreviation, String nomVoie) {
		super();
		this.id = id;
		this.abreviation = abreviation;
		this.nomVoie = nomVoie;
	}
	/**
	 * @return the abreviation
	 */
	public String getAbreviation() {
		return abreviation;
	}
	/**
	 * @param abreviation the abreviation to set
	 */
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
	/**
	 * @return the nomVoie
	 */
	public String getNomVoie() {
		return nomVoie;
	}
	/**
	 * @param nomVoie the nomVoie to set
	 */
	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}
	/**
	 * 
	 */
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



}
