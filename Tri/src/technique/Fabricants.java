/**
 * 
 */
package technique;

import java.util.ArrayList;
import java.util.Collection;

import metier.decheterie.Fabricant;

/**
 * @author Mehdi HAMDI
 *
 */
public class Fabricants extends ArrayList<Fabricant> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Fabricants() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param c
	 */
	public Fabricants(Collection<? extends Fabricant> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param initialCapacity
	 */
	public Fabricants(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

}
