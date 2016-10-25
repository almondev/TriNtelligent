/**
 * 
 */
package technique;

import java.util.ArrayList;
import java.util.Collection;

import metier.decheterie.Voie;

/**
 * @author Mehdi HAMDI
 *
 */
public class Voies<Voie> extends ArrayList<Voie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Voies() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param c
	 */
	public Voies(Collection<? extends Voie> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param initialCapacity
	 */
	public Voies(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

}
