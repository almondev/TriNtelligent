package metier.decheterie;

import java.util.Collection;
import java.util.TreeSet;

public class TriGenere {
	/**
	 * @return the refF
	 */
	public Collection<RefFabricant> getRefF() {
		return refF;
	}
	/**
	 * @param refF the refF to set
	 */
	public void setRefF(Collection<RefFabricant> refF) {
		this.refF = refF;
	}
	/**
	 * @return the collecteurs
	 */
	public Collection<Collecteur> getCollecteurs() {
		return collecteurs;
	}
	/**
	 * @param collecteurs the collecteurs to set
	 */
	public void setCollecteurs(Collection<Collecteur> collecteurs) {
		this.collecteurs = collecteurs;
	}
	/**
	 * @return the emplacements
	 */
	public Collection<Lieu> getEmplacements() {
		return emplacements;
	}
	/**
	 * @param emplacements the emplacements to set
	 */
	public void setEmplacements(Collection<Lieu> emplacements) {
		this.emplacements = emplacements;
	}
	private Collection<RefFabricant> refF;
	private Collection<Collecteur>  collecteurs;
	private Collection<Lieu> emplacements;
	/**
	 * 
	 */
	public TriGenere() {
		super();
		// TODO Auto-generated constructor stub
		refF		 = new TreeSet<RefFabricant>();
		collecteurs  = new TreeSet<Collecteur>();
		emplacements = new TreeSet<Lieu>();
		
		
		
		
	}
	
	

}
