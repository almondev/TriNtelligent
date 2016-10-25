package technique;

import java.util.ArrayList;

import metier.decheterie.Lieu;
import metier.decheterie.Produit;



public class Produits extends ArrayList<Produit> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Produit getProduit(String nomProduit) {
		try {


			for (Produit produit : this) {


				if (produit.getNomProduit().equalsIgnoreCase(nomProduit)) {

					return produit;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}	
}