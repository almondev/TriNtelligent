/**
 * 
 */
package dao;

import java.awt.Color;
import java.time.LocalDate;
import java.time.Month;

import metier.decheterie.Collecteur;
import metier.decheterie.Colonne;
import metier.decheterie.Lieu;
import metier.decheterie.Voie;
import metier.decheterie.Commune;
import metier.decheterie.EmplacementDechetterie;
import metier.decheterie.EmplacementDistributeur;
import metier.decheterie.EmplacementExterne;
import metier.decheterie.Produit;
import metier.decheterie.Sac;
import metier.decheterie.Fabricant;

import technique.Collecteurs;
import technique.Lieux;
import technique.Voies;
import technique.Communes;
import technique.Produits;
import technique.Fabricants;
/**
 * @author Mehdi HAMDI
 *
 */
public class Datas {








	/**
	 * @return the collecteurs
	 */
	public static Collecteurs getCollecteurs() {
		return collecteurs;
	}



	/**
	 * @param collecteurs the collecteurs to set
	 */
	public static void setCollecteurs(Collecteurs collecteurs) {
		Datas.collecteurs = collecteurs;
	}



	/**
	 * @return the voies
	 */
	public static Voies<Voie> getVoies() {
		return voies;
	}



	/**
	 * @param voies the voies to set
	 */
	public static void setVoies(Voies<Voie> voies) {
		Datas.voies = voies;
	}



	/**
	 * @return the communes
	 */
	public static Communes<Commune> getCommunes() {
		return communes;
	}



	/**
	 * @param communes the communes to set
	 */
	public static void setCommunes(Communes<Commune> communes) {
		Datas.communes = communes;
	}



	/**
	 * @return the fabricants
	 */
	public static Fabricants getFabricants() {
		return fabricants;
	}



	/**
	 * @param fabricants the fabricants to set
	 */
	public static void setFabricants(Fabricants fabricants) {
		Datas.fabricants = fabricants;
	}






	/**
	 * @return the produits
	 */
	public static Produits getProduits() {
		return produits;
	}



	/**
	 * @param produits the produits to set
	 */
	public static void setProduits(Produits produits) {
		Datas.produits = produits;
	}






	//
	private static String					choixConnexion 	="afpa";
	private static Collecteurs 				collecteurs 	= new Collecteurs();
	private static Lieux 					lieux			= new Lieux();
	private static Voies<Voie>				voies			= new Voies<Voie>();
	private static Communes<Commune>		communes		= new Communes<Commune>();
	private static Fabricants				fabricants		= new Fabricants();
	private static Produits					produits		= new Produits();
	
	public static void Initial() {
		
		
		
		//Initialisation des produits
		produits.add(new Produit(1,"vert"));
		produits.add(new Produit(2,"jaune"));
		produits.add(new Produit(3,"marron"));
		
		
		
		//Initialisation des voies
		//https://www.monalbumphoto.fr/aide/livraison/abreviation-voie
		System.out.println("Ajout Voie:");
//		VoieDAO vDAO = new VoieDAO();
//		vDAO.removeAll();
//
//
//		vDAO.add(new Voie(1,"ABE","abbaye"));
//		vDAO.add(new Voie(2,"AGL","abbaye"));
//		vDAO.add(new Voie(3,"AIRE","Aire(s)"));
//		vDAO.add(new Voie(4,"ALL","Allée(s)"));
//		vDAO.add(new Voie(5,"ACH","Ancien chemin"));
//		vDAO.add(new Voie(6,"ART","Ancienne route(s)"));
//		vDAO.add(new Voie(7,"ANSE","Anse"));
//		vDAO.add(new Voie(8,"ARC","Arcade(s)"));
//		vDAO.add(new Voie(9,"BOIS","Bois"));
//		vDAO.add(new Voie(10,"BD","Boulevard"));
//		vDAO.add(new Voie(11,"BUT","Butte"));
//		vDAO.add(new Voie(12,"CAMP","Camp"));
//		vDAO.add(new Voie(13,"CGNE","Campagne"));		
//		vDAO.add(new Voie(14,"CHE","Chemin(s)"));
//		vDAO.add(new Voie(15,"CHEZ","Chez"));
//		vDAO.add(new Voie(16,"CITE","Cîte(s)"));
//		vDAO.add(new Voie(17,"COLI","Colline(s)"));
//		vDAO.add(new Voie(18,"COTE","Côte(au)"));
//		vDAO.add(new Voie(19,"CRS","Cours"));
//		vDAO.add(new Voie(20,"DOM","Domaine(s)"));
//		vDAO.add(new Voie(21,"ESPA","Espace"));
//		vDAO.add(new Voie(22,"FG","Faubourg"));
//		vDAO.add(new Voie(23,"FOS","Fosse(s)"));
//		vDAO.add(new Voie(24,"GARE","Gare"));
//		vDAO.add(new Voie(25,"HAM","Hameau(x)"));
//		vDAO.add(new Voie(26,"IMP","Impasse(s)"));
//		vDAO.add(new Voie(27,"JTE","Jetée(s)"));
//		vDAO.add(new Voie(28,"LD","Lieu dit"));
//		vDAO.add(new Voie(29,"LOT ","Lotissement(s)"));
//		vDAO.add(new Voie(30,"PAE","Petite avenue"));
//		vDAO.add(new Voie(31,"PLAG","Plage(s)"));
//		vDAO.add(new Voie(32,"PONT","Pont(s)"));
//		vDAO.add(new Voie(33,"PROM","Promenade"));
//		vDAO.add(new Voie(34,"RPT","Rond point"));
//		vDAO.add(new Voie(35,"R","Rue(s)"));
//		vDAO.add(new Voie(36,"SEN","Sente(ier)(s)"));
//		vDAO.add(new Voie(37,"SQ","Square"));
//		vDAO.add(new Voie(38,"TRN","Terrain"));
//		vDAO.add(new Voie(39,"VIA","Via"));
//		vDAO.add(new Voie(40,"VGE","Village(s)"));
//		vDAO.add(new Voie(41,"VOI","Voie(s) "));
//		vDAO.add(new Voie(42,"ZONE","Zone"));

		//if (taille > 0){

		voies.add(new Voie(1,"ABE","Abbaye"));
		voies.add(new Voie(2,"AGL","Agglomeration"));
		voies.add(new Voie(3,"AIRE","Aire(s)"));
		voies.add(new Voie(4,"ALL","Allée(s)"));
		voies.add(new Voie(5,"ACH","Ancien chemin"));
		voies.add(new Voie(6,"ART","Ancienne route(s)"));
		voies.add(new Voie(7,"ANSE","Anse"));
		voies.add(new Voie(8,"ARC","Arcade(s)"));
		voies.add(new Voie(9,"BOIS","Bois"));
		voies.add(new Voie(10,"BD","Boulevard"));
		voies.add(new Voie(11,"BUT","Butte"));
		voies.add(new Voie(12,"CAMP","Camp"));
		voies.add(new Voie(13,"CGNE","Campagne"));
		voies.add(new Voie(14,"CHE","Chemin(s)"));
		voies.add(new Voie(15,"CHEZ","Chez"));
		voies.add(new Voie(16,"CITE","Cîte(s)"));
		voies.add(new Voie(17,"COLI","Colline(s)"));
		voies.add(new Voie(18,"COTE","Côte(au)"));
		voies.add(new Voie(19,"CRS","Cours"));
		voies.add(new Voie(20,"DOM","Domaine(s)"));
		voies.add(new Voie(21,"ESPA","Espace"));
		voies.add(new Voie(22,"FG","Faubourg"));
		voies.add(new Voie(23,"FOS","Fosse(s)"));
		voies.add(new Voie(24,"GARE","Gare"));
		voies.add(new Voie(25,"HAM","Hameau(x)"));
		voies.add(new Voie(26,"IMP","Impasse(s)"));
		voies.add(new Voie(27,"JTE","Jetée(s)"));
		voies.add(new Voie(28,"LD","Lieu dit"));
		voies.add(new Voie(29,"LOT ","Lotissement(s)"));
		voies.add(new Voie(30,"PAE","Petite avenue"));
		voies.add(new Voie(31,"PLAG","Plage(s)"));
		voies.add(new Voie(32,"PONT","Pont(s)"));
		voies.add(new Voie(33,"PROM","Promenade"));
		voies.add(new Voie(34,"RPT","Rond point"));
		voies.add(new Voie(35,"R","Rue(s)"));
		voies.add(new Voie(36,"SEN","Sente(ier)(s)"));
		voies.add(new Voie(37,"SQ","Square"));
		voies.add(new Voie(38,"TRN","Terrain"));
		voies.add(new Voie(39,"VIA","Via"));
		voies.add(new Voie(40,"VGE","Village(s)"));
		voies.add(new Voie(41,"VOI","Voie(s) "));
		voies.add(new Voie(42,"ZONE","Zone"));
		
		//Ajout des communes
//		CommuneDao cDao = new CommuneDao();
//		cDao.removeAll();
//		//Communes créations de 100 communces.
//		cDao.add(new Commune(1,"Marseille"));
//		cDao.add(new Commune(2,"Aix-en-Provence"));
//		cDao.add(new Commune(3,"Toulon"));
//		cDao.add(new Commune(4,"Martigues"));
//		cDao.add(new Commune(5,"La Ciotat"));
//		cDao.add(new Commune(6,"Allauch"));
//		cDao.add(new Commune(7,"Avignon"));
//		cDao.add(new Commune(8,"Nice"));
//		cDao.add(new Commune(9,"Gap"));
//		cDao.add(new Commune(10,"Sisteron"));
//		cDao.add(new Commune(11,"Paris"));
//		cDao.add(new Commune(12,"Lyon"));
//		cDao.add(new Commune(13,"Besançon"));
//		cDao.add(new Commune(14,"Grenoble"));
//		cDao.add(new Commune(15,"Monaco"));
//		cDao.add(new Commune(16,"Montpellier"));
		for(int i=0;i<100;i++){
			//cDao.add(new Commune(i+1,"Commune"+i));
			communes.add(new Commune(i+1,"Commune"+i));
		}
		// 10 Fabricant
		
		//Ajout des fabicant:
		//FabricantDao fDao 	= new FabricantDao();
		//fDao.removeAll();
		
		for(int i=0;i<10;i++){
			//fDao.add(new Fabricant((i+1),"Fabricant"+i));
			//fDao.close();
			fabricants.add(new Fabricant((i+1),"Fabricant_"+i));
			
		}
	
		int lowerVoie = 1;
		int higherVoie = 42;
		int lowerCommune = 1;
		int higherCommune = 100;
		int lowerNombreMaxCollecteurs=1;
		int higherNombreMaxCollecteurs=5;
		//Lieux
		
		System.out.println("Emplacement");
		
		//Initialisation des adresses
		// 10 Emplacement externes
		for(int i=0;i<10;i++){	
			int randomVoie = (int)(Math.random() * (higherVoie-lowerVoie)) + lowerVoie;
			int randomCommune = (int)(Math.random() * (higherCommune-lowerCommune)) + lowerCommune;
			int randmaxNombreMaxCollecteurs = (int)(Math.random() * (higherNombreMaxCollecteurs-lowerNombreMaxCollecteurs)) + lowerNombreMaxCollecteurs;

			EmplacementExterne unEmplacementExterne = new EmplacementExterne(i,i,voies.get(randomVoie),"adresse"+i,"Complement adresse"+i,communes.get(randomCommune),randRange(1.000F,500.F),randRange(1.000F,500.F),randmaxNombreMaxCollecteurs);
			lieux.add(unEmplacementExterne);
		}
		// 10 Emplacements Distributeurs
		for(int i=10;i<20;i++){
			int randomVoie = (int)(Math.random() * (higherVoie-lowerVoie)) + lowerVoie;
			int randomCommune = (int)(Math.random() * (higherCommune-lowerCommune)) + lowerCommune;
			//int randmaxNombreMaxCollecteurs = (int)(Math.random() * (higherNombreMaxCollecteurs-lowerNombreMaxCollecteurs)) + lowerNombreMaxCollecteurs;
			EmplacementDistributeur unEmplacementDistributeur = new EmplacementDistributeur(i,i,voies.get(randomVoie),"adresse"+i,"Complement adresse"+i,communes.get(randomCommune),randRange(1.000F,500.F),randRange(1.000F,500.F),"Ditributeur_"+(i-10));
			lieux.add(unEmplacementDistributeur);
		}
		// 10 Emplacements Dechétterie
		for(int i=20;i<30;i++){ 
			int randomVoie = (int)(Math.random() * (higherVoie-lowerVoie)) + lowerVoie;
			int randomCommune = (int)(Math.random() * (higherCommune-lowerCommune)) + lowerCommune;
			boolean bOuvertWE= true; 
			if ((i % 2) ==0) {
				bOuvertWE = true;
			} else {
				bOuvertWE = false;
			}
			EmplacementDechetterie unEmplacementDechetterie = new EmplacementDechetterie(i,i,voies.get(randomVoie),"adresse"+i,"Complement adresse"+i,communes.get(randomCommune),randRange(1.000F,500.F),randRange(1.000F,500.F),"Dechetterie_"+i,bOuvertWE);
			
			lieux.add(unEmplacementDechetterie);
		}
		
		
		//Dates
		LocalDate [] date = new LocalDate[26];
		date[0]  = LocalDate.of(2005,Month.DECEMBER,1);
		date[1]  = LocalDate.of(2005,Month.JANUARY,2);
		date[2]  = LocalDate.of(2005,Month.APRIL,3);
		date[3]  = LocalDate.of(2005,Month.OCTOBER,4);
		date[4]  = LocalDate.of(2005,Month.SEPTEMBER,5);
		date[5]  = LocalDate.of(2005,Month.DECEMBER,6);
		date[6]  = LocalDate.of(2005,Month.DECEMBER,7);
		date[7]  = LocalDate.of(2005,Month.DECEMBER,8);
		date[8]  = LocalDate.of(2005,Month.DECEMBER,9);
		date[9]  = LocalDate.of(2005,Month.DECEMBER,10);
		date[10] = LocalDate.of(2005,Month.DECEMBER,11);
		date[11] = LocalDate.of(2005,Month.DECEMBER,12);
		date[12] = LocalDate.of(2005,Month.DECEMBER,13);
		date[13] = LocalDate.of(2005,Month.DECEMBER,14);
		date[14] = LocalDate.of(2005,Month.DECEMBER,15);
		date[15] = LocalDate.of(2005,Month.DECEMBER,16);
		date[16] = LocalDate.of(2005,Month.DECEMBER,17);
		date[17] = LocalDate.of(2005,Month.DECEMBER,18);
		date[18] = LocalDate.of(2005,Month.DECEMBER,19);
		date[19] = LocalDate.of(2005,Month.DECEMBER,20);
		date[20] = LocalDate.of(2005,Month.DECEMBER,21);
		date[21] = LocalDate.of(2005,Month.DECEMBER,22);
		date[22] = LocalDate.of(2005,Month.DECEMBER,23);
		date[23] = LocalDate.of(2005,Month.DECEMBER,24);
		date[24] = LocalDate.of(2005,Month.DECEMBER,25);
		date[25] = LocalDate.of(2005,Month.DECEMBER,26);
		
		
		//Initialisation des Collecteurs
		// 10 colonnes
		int choixProduit;
		int lowerProduit  = 0;
		int higherProduit = 2;
		int lowerRefFabri = 1;
		int higherRefFabri = 9999;
		int randomLieux;
		LocalDate dateNull =null;
		for(int i=0;i<10;i++){	
			int randomProduit = (int)(Math.random() * (higherProduit-lowerProduit)) + lowerProduit;
			int indexRefFabricant = (int)(Math.random() * (higherRefFabri-lowerRefFabri)) + lowerRefFabri;
			int etatCollecteur= (int)(Math.random() * (4-0)) + 0;
			randomLieux =  (int)(Math.random() * (20-0)) + 0;
			collecteurs.add(new Colonne("colonne"+i,produits.get(randomProduit),date[i],date[i],dateNull,"Fabricant_"+i,"ref_fabricant"+indexRefFabricant,lieux.get(randomLieux),Collecteur.ETAT[etatCollecteur],true,true,true,2));
			
		}
	
		
		Color [] colors = new Color[10];
		colors[0] = Color.BLACK;
		colors[1] = Color.BLUE;
		colors[2] = Color.GRAY;
		colors[3] = Color.GREEN;
		colors[4] = Color.YELLOW;
		colors[5] = Color.MAGENTA;
		colors[6] = Color.ORANGE;
		colors[7] = Color.PINK;
		colors[8] = Color.RED;
		colors[9] = Color.WHITE;
		
		
		// 10 sacs
		for(int i=0;i<10;i++){	
			int randomProduit = (int)(Math.random() * (higherProduit-lowerProduit)) + lowerProduit;
			int indexRefFabricant = (int)(Math.random() * (higherRefFabri-lowerRefFabri)) + lowerRefFabri;
			int etatCollecteur= (int)(Math.random() * (4-0)) + 0;
			randomLieux =  (int)(Math.random() * (20-0)) + 0;
			collecteurs.add(new Sac("colonne"+i,produits.get(randomProduit),date[i],date[i],dateNull,"Fabricant_"+i,"Ref_"+indexRefFabricant,lieux.get(randomLieux),Collecteur.ETAT[etatCollecteur],true,colors[i]));
			
		}


		// 10 boites
		//lieux.add(new Boite());

		
		// 10 Meubles
		
		
		
	}
	
	
	
	/**
	 * @return the lieux
	 */
	public static Lieux getLieux() {
		return lieux;
	}



	/**
	 * @param lieux the lieux to set
	 */
	public static void setLieux(Lieux lieux) {
		Datas.lieux = lieux;
	}



	private static float randRange(float min, float max) {
		return min + (float)Math.random() * (max - min);
	}
	
	
	
	public Collecteur insertCollecteur(Collecteur typeCollecteur){
		Collecteur newCollecteur = null;
		return newCollecteur;
		
	}



	public static String getChoixConnexion() {
		return choixConnexion;
	}



	public static void setChoixConnexion(String choixConnexion) {
		Datas.choixConnexion = choixConnexion;
	}
	
	



}
