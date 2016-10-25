/**
 * 
 */
package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import vue.jpanel.PanelAppli;
import vue.jpanel.PanelListeCollecteur;
import vue.jpanel.PanelCrudCollecteur;
import vue.jpanel.PanelLieu;
import vue.jpanel.PanelCollecteur;

/**
 * @author Mehdi HAMDI
 *
 */
public class FenetreDecheterie extends Fenetre {






	/**
	 * @return the listePanelAppli
	 */
	public PanelAppli[] getListePanelAppli() {
		return listePanelAppli;
	}


	/**
	 * @param listePanelAppli the listePanelAppli to set
	 */
	public void setListePanelAppli(PanelAppli[] listePanelAppli) {
		this.listePanelAppli = listePanelAppli;
	}


	/**
	 * 
	 */
	PanelAppli[] listePanelAppli;
	
	
	public FenetreDecheterie() {
		super();
		// TODO Auto-generated constructor stub
		

		

		//JPanel
		listePanelAppli = new PanelAppli[2];
		listePanelAppli[0] = new PanelCollecteur(this);
		listePanelAppli[1] = new PanelListeCollecteur(this);
		//listePanelAppli[2] = new PanelLieu(this);
		//listePanelAppli[3] = new PanelCrudCollecteur(this);
		getContent().setLayout(new GridLayout(1,2));
		getContent().setBackground(new Color(125,160,240));
		Color couleurPan;
		for (int i=0; i < listePanelAppli.length; i++) {
			if(i==0){
				couleurPan =Color.BLUE;
			} else {
				couleurPan =Color.DARK_GRAY;	
			}
			listePanelAppli[i].setBorder(BorderFactory.createLineBorder(couleurPan));
		}	
		for (int i=0; i < listePanelAppli.length; i++) {
			getContent().add(listePanelAppli[i]);
		}
		

		
		
	}
	


	

	
	
	
	

}
