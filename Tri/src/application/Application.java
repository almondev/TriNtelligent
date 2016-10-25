package application;

import javax.swing.UIManager;

import dao.Datas;
import vue.Fenetre;
import vue.FenetreAccueil;
import vue.FenetreDecheterie;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialisation des données
		System.out.println("Début Datas");
		Datas.Initial();
		System.out.println("Début Fenêtre");
		String refLieu = "2 : numero=2, voie=Camp, adresse=adresse2, complementAdresse=Complement adresse2, Commune=Commune56, lattitude=413.2908, longitude=295.1286]";
		String str2;
		int positionDeuxPoints = refLieu.indexOf(':');
		str2 =refLieu.substring(0, positionDeuxPoints).trim();
		System.out.println("str2 ="+str2+"; inde = "+positionDeuxPoints);
		try {
			
			String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel);
//			 UIManager.setLookAndFeel(
//	                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());

			Fenetre fenetreAccueil = new FenetreAccueil();
			fenetreAccueil.pack();
			fenetreAccueil.setVisible(true);

//			Fenetre fenetre = new FenetreDecheterie();
//			fenetre.pack();
//			fenetre.setVisible(true);
		}
		catch(Exception e) {
			System.out.println("Erreur DM : " + e.getMessage() );
		}

	}

}
