/**
 * 
 */
package technique;

import java.util.ArrayList;
import metier.decheterie.Lieu;



/**
 * @author Mehdi HAMDI
 *
 */
public class Lieux extends ArrayList<Lieu> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Lieu getLieu(String nomLieu) {
		int positionDeuxPoints = nomLieu.indexOf(':');
		String refLieu = nomLieu.substring(0, positionDeuxPoints).trim();
		System.out.println("nomLieu"+nomLieu+";reflieu ="+refLieu);
		Lieu lieuTrouve = null;
		int nbLieu;
		try {
			nbLieu =Integer.parseInt(refLieu);
			

			for (Lieu lieu : this) {


				if (lieu.getRefLieu()== nbLieu) {
					lieuTrouve = lieu;
					return lieuTrouve;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lieuTrouve;
	}	
	/**
	 * 
	 * @param editeur
	 * @return index
	 */
	public int indexEditeur(Lieu lieu){
		int index = 0;
		for (Lieu unLieuDeList : this) {
			if (unLieuDeList.getRefLieu()==lieu.getRefLieu()){
				return index;
			}
			index++;
		}
		return index;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
