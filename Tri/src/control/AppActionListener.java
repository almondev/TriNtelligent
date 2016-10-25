/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import dao.CommuneDao;
import dao.Datas;
import dao.LieuDao;
import dao.VoieDAO;
import metier.decheterie.Colonne;
import metier.decheterie.Commune;
import metier.decheterie.EmplacementDechetterie;
import metier.decheterie.EmplacementDistributeur;
import metier.decheterie.EmplacementExterne;
import metier.decheterie.Lieu;
import metier.decheterie.Produit;
import metier.decheterie.Voie;
import outils.Rsa;
import vue.Fenetre;
import vue.FenetreAccueil;
import vue.FenetreCreateLieu;
import vue.FenetreDecheterie;

import vue.jpanel.PanelListeCollecteur;
import vue.jpanel.PanelCollecteur;
/**
 * @author Mehdi HAMDI
 *
 */
public class AppActionListener implements ActionListener {

	private Fenetre fenetre;
	private FenetreDecheterie fenetreDechetterie;

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (fenetre instanceof FenetreDecheterie) {
			//FenetreDecheterie new_fenetreDecheterie = (FenetreDecheterie) fenetre;
			//PanelListeCollecteur panelListeCollecteur = (PanelListeCollecteur) new_fenetreDecheterie.getListePanelAppli()[1];
			//PanelCollecteur 
			if (e.getSource() == ((PanelListeCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[1]).getBtnInsert()) {
				//System.out.println("coucou");

				String nomCollecteur 	= ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getTxtNomCollecteur().getText();
				String nomFabricant 	= ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getTxtNomFabricant().getText();
				String refFabricant 	= ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getTxtRefFabricant().getText();
				String strDateCreation 	= ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getTxtDateCreation().getText();
				DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				LocalDate dateCreation = LocalDate.parse(strDateCreation, dTF);
				LocalDate ldnull =null;

				//Produit produit = Datas.getProduits().getProduit(((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getChoixProduit());
				Produit produit = Datas.getProduits().getProduit(((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getChoixProduit());

				System.out.println("prduit :"+produit.toString());
				Lieu    lieu	= Datas.getLieux().getLieu(((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getCboLieu().getSelectedItem().toString());
				System.out.println("lieu :"+lieu);

				Datas.getCollecteurs().add(new Colonne(nomCollecteur,produit,dateCreation, dateCreation,ldnull, nomFabricant, refFabricant,lieu,"correcte",true,true,true,2));

				//Datas.getCollecteurs().add(new Colonne(nomCollecteur,new Produit("déchet jaune"),LocalDate.of(2005,Month.DECEMBER,1),LocalDate.of(2005,Month.DECEMBER,1),ldnull,"Fabricant_"+1,"Fabricant_",new EmplacementDechetterie(255,255,Datas.getVoies().get(11),"adresse"+225,"Complement adresse"+225,Datas.getCommunes().get(14).getNomCommune(),500.F,1.000F,"Dechetterie_"+255,true),"correcte",true,true,true,2));
				//Datas.getCollecteurs().addCollecteur(new Colonne(), nomCollecteur, produit, dateCreation, dateMiseAJour, indexRefFabricant, referenceFabricant, emplacement, etatCollecteur, estSurSite, estInsonorise, estEnterree, nbPortes)
				((PanelListeCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[1]).refreshJTableauCollecteurs();
			}
			if (e.getSource() == ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getRadioVert()) {
				((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).setChoixProduit("Vert");
			}
			if (e.getSource() == ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getRadioJaune()) {
				((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).setChoixProduit("Jaune");
			}
			if (e.getSource() == ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getRadioMarron()) {
				((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).setChoixProduit("Marron");
			}
			if (e.getSource() == ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getRadioColonne()) {
				((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).setChoixCollecteur("Colonne");
			}		
			if (e.getSource() == ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getRadioMeuble()) {
				((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).setChoixCollecteur("Meuble");
			}	
			if (e.getSource() == ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getRadioSac()) {
				((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).setChoixCollecteur("Sac");
			}
			if (e.getSource() == ((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getRadioBoite()) {
				((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).setChoixCollecteur("Boite");
				((PanelCollecteur) ((FenetreDecheterie) fenetre).getListePanelAppli()[0]).getTxtArea().setText("Boite");
			}	
		}

		if (fenetre instanceof FenetreAccueil) {
			if  (e.getSource() == ((FenetreAccueil) fenetre).getOptHome()) {
				Datas.setChoixConnexion("maison");
			}
			if  (e.getSource() == ((FenetreAccueil) fenetre).getOptAfpa()) {
				Datas.setChoixConnexion("afpa");
			}
			if  (e.getSource() == ((FenetreAccueil) fenetre).getCmdConnexion()) {
				//custom title, no icon

				afficheFenetre(fenetre);

			}
			if  (e.getSource() == ((FenetreAccueil) fenetre).getCmdPasser()) {
				afficheFenetre(fenetre);
			}			

		}
		if (fenetre instanceof FenetreCreateLieu) {
			if  (e.getSource() == ((FenetreCreateLieu) fenetre).getCmdClear()) {
				
			}
			if  (e.getSource() == ((FenetreCreateLieu) fenetre).getCmdDelete()) {
				
			}
			if  (e.getSource() == ((FenetreCreateLieu) fenetre).getCmdInsert()) {
				Lieu lieuChoisi;
				VoieDAO 	vDao =  new VoieDAO(); 
				CommuneDao 	cDao = 	new CommuneDao();
				int 	numero = Integer.parseInt(((FenetreCreateLieu) fenetre).getTxtNumero().getText()); // numéro de la voie
				Voie 	voie = vDao.getEChamp(((FenetreCreateLieu) fenetre).getCboVoie().getSelectedItem().toString());
				String 	adresse= ((FenetreCreateLieu) fenetre).getTxtAdresse().getText();
				String 	complementAdresse = ((FenetreCreateLieu) fenetre).getTxtComplementAdresse().getText();;
				Commune commune = cDao.getEChamp(((FenetreCreateLieu) fenetre).getCboCommune().getSelectedItem().toString());
				float 	lattitude = Float.parseFloat(((FenetreCreateLieu) fenetre).getTxtLattitude().getText());
				float 	longitude = Float.parseFloat(((FenetreCreateLieu) fenetre).getTxtLongitude().getText());
				String nomDechetterie=((FenetreCreateLieu) fenetre).getTxtNomDechetterie().getText();
				Boolean ouvertWeekEnd=((FenetreCreateLieu) fenetre).getOptOuvertWeekEnd().isSelected();
				String nomDistributeur=((FenetreCreateLieu) fenetre).getTxtNomDistributeur().getText();
		
				if(((FenetreCreateLieu) fenetre).getChoixEmplacement().equals("DECHETTERIE")){

					lieuChoisi = new EmplacementDechetterie(numero, voie, adresse, complementAdresse, commune, lattitude, longitude, nomDechetterie, ouvertWeekEnd);
					
				} else if (((FenetreCreateLieu) fenetre).getChoixEmplacement().equals("DISTRIBUTEUR")){
					lieuChoisi = new EmplacementDistributeur(numero, voie, adresse, complementAdresse, commune, lattitude, longitude, nomDistributeur);
				} else {
					//TODO Erreur Integer.parseInt
					int nombreMaxCollecteurs=Integer.parseInt(((FenetreCreateLieu) fenetre).getTxtNombreMaxCollecteurs().getText());
					
					lieuChoisi = new EmplacementExterne(numero, voie, adresse, complementAdresse, commune, lattitude, longitude, nombreMaxCollecteurs);
				}
				LieuDao lieuDao = new LieuDao();
				lieuDao.add(lieuChoisi);
				
				
			}
			if  (e.getSource() == ((FenetreCreateLieu) fenetre).getCmdSearch()) {
				
			}			
			if  (e.getSource() == ((FenetreCreateLieu) fenetre).getCmdUpdate()) {
				
			}
			
			
			
			if  (e.getSource() == ((FenetreCreateLieu) fenetre).getRadioDechetterie()) {
				((FenetreCreateLieu) fenetre).setChoixEmplacement("DECHETTERIE");
			}

			
			if  (e.getSource() == ((FenetreCreateLieu) fenetre).getRadioDistributeur()) {
				((FenetreCreateLieu) fenetre).setChoixEmplacement("DISTRIBUTEUR");
			}	
			
			
			if  (e.getSource() == ((FenetreCreateLieu) fenetre).getRadioExterne()) {
				((FenetreCreateLieu) fenetre).setChoixEmplacement("EXTERNE");
			}
			
		}
	}

	/**
	 * 
	 */
	public AppActionListener(Fenetre fenetre) {
		super();
		this.fenetre = fenetre;

		// TODO Auto-generated constructor stub
		//		if (e.getSource() == fenetre.getBtnInsert()) {
		//			
		//		}
	}
	public void afficheFenetre(Fenetre fenetre){
		try {

			String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel);
			//		 UIManager.setLookAndFeel(
			//                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());

			//			Fenetre fenetreAccueil = new FenetreAccueil();
			//			fenetreAccueil.pack();
			//			fenetreAccueil.setVisible(true);
			String txtLogin		=((FenetreAccueil) fenetre).getTxtLogin().getText();
			String txtPassword	=((FenetreAccueil) fenetre).getTxtPassword().getText();
			
			if(Rsa.verifieLoginEtPassword(txtLogin, txtPassword)){
				//Test la connexion
				System.out.println();
				
			}else{
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,
						"Eggs are not supposed to be green.",
						"A plain message",
						JOptionPane.PLAIN_MESSAGE);
			}
			Fenetre fenetreDecheterie = new FenetreDecheterie();
			fenetreDecheterie.pack();
			fenetreDecheterie.setVisible(true);
		}
		catch(Exception e) {
			System.out.println("Erreur DM : " + e.getMessage() );
		}
	}

}
