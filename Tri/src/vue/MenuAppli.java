/**
 * 
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import metier.decheterie.EmplacementDechetterie;




/**
 * @author Mehdi HAMDI
 *
 */
public class MenuAppli extends JMenuBar implements ActionListener, ItemListener{
	private JMenuItem mnuFichierQuitter = new JMenuItem("Quitter", 'Q');
	FenetreListLieux fenetreListLieux;
	/**
	 * @return the fenetre
	 */
	public Fenetre getFenetre() {
		return fenetre;
	}
	/**
	 * @param fenetre the fenetre to set
	 */
	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	/**
	 * @return the menuDechets
	 */
	public JMenu getMenuDechets() {
		return menuDechets;
	}
	/**
	 * @param menuDechets the menuDechets to set
	 */
	public void setMenuDechets(JMenu menuDechets) {
		this.menuDechets = menuDechets;
	}
	/**
	 * @return the menuCollecteurs
	 */
	public JMenu getMenuCollecteurs() {
		return menuCollecteurs;
	}
	/**
	 * @param menuCollecteurs the menuCollecteurs to set
	 */
	public void setMenuCollecteurs(JMenu menuCollecteurs) {
		this.menuCollecteurs = menuCollecteurs;
	}
	/**
	 * @return the menuEmplacements
	 */
	public JMenu getMenuEmplacements() {
		return menuEmplacements;
	}
	/**
	 * @param menuEmplacements the menuEmplacements to set
	 */
	public void setMenuEmplacements(JMenu menuEmplacements) {
		this.menuEmplacements = menuEmplacements;
	}
	/**
	 * @return the menuHelp
	 */
	public JMenu getMenuHelp() {
		return menuHelp;
	}
	/**
	 * @param menuHelp the menuHelp to set
	 */
	public void setMenuHelp(JMenu menuHelp) {
		this.menuHelp = menuHelp;
	}
	/**
	 * @return the menuAide
	 */
	public JMenu getMenuAide() {
		return menuAide;
	}
	/**
	 * @param menuAide the menuAide to set
	 */
	public void setMenuAide(JMenu menuAide) {
		this.menuAide = menuAide;
	}
	/**
	 * @return the menuCreerDechets
	 */
	public JMenuItem getMenuCreerDechets() {
		return menuCreerDechets;
	}
	/**
	 * @param menuCreerDechets the menuCreerDechets to set
	 */
	public void setMenuCreerDechets(JMenuItem menuCreerDechets) {
		this.menuCreerDechets = menuCreerDechets;
	}
	/**
	 * @return the menuModifierDechets
	 */
	public JMenuItem getMenuModifierDechets() {
		return menuModifierDechets;
	}
	/**
	 * @param menuModifierDechets the menuModifierDechets to set
	 */
	public void setMenuModifierDechets(JMenuItem menuModifierDechets) {
		this.menuModifierDechets = menuModifierDechets;
	}
	/**
	 * @return the menuListerDechets
	 */
	public JMenuItem getMenuListerDechets() {
		return menuListerDechets;
	}
	/**
	 * @param menuListerDechets the menuListerDechets to set
	 */
	public void setMenuListerDechets(JMenuItem menuListerDechets) {
		this.menuListerDechets = menuListerDechets;
	}
	/**
	 * @return the menuCreerCollecteur
	 */
	public JMenuItem getMenuCreerCollecteur() {
		return menuCreerCollecteur;
	}
	/**
	 * @param menuCreerCollecteur the menuCreerCollecteur to set
	 */
	public void setMenuCreerCollecteur(JMenuItem menuCreerCollecteur) {
		this.menuCreerCollecteur = menuCreerCollecteur;
	}
	/**
	 * @return the menuModifierCollecteur
	 */
	public JMenuItem getMenuModifierCollecteur() {
		return menuModifierCollecteur;
	}
	/**
	 * @param menuModifierCollecteur the menuModifierCollecteur to set
	 */
	public void setMenuModifierCollecteur(JMenuItem menuModifierCollecteur) {
		this.menuModifierCollecteur = menuModifierCollecteur;
	}
	/**
	 * @return the menuListeCollecteur
	 */
	public JMenuItem getMenuListeCollecteur() {
		return menuListeCollecteur;
	}
	/**
	 * @param menuListeCollecteur the menuListeCollecteur to set
	 */
	public void setMenuListeCollecteur(JMenuItem menuListeCollecteur) {
		this.menuListeCollecteur = menuListeCollecteur;
	}
	/**
	 * @return the menuCreerEmplacement
	 */
	public JMenuItem getMenuCreerEmplacement() {
		return menuCreerEmplacement;
	}
	/**
	 * @param menuCreerEmplacement the menuCreerEmplacement to set
	 */
	public void setMenuCreerEmplacement(JMenu menuCreerEmplacement) {
		this.menuCreerEmplacement = menuCreerEmplacement;
	}
	/**
	 * @return the menuModifierEmplacement
	 */
	public JMenuItem getMenuModifierEmplacement() {
		return menuModifierEmplacement;
	}
	/**
	 * @param menuModifierEmplacement the menuModifierEmplacement to set
	 */
	public void setMenuModifierEmplacement(JMenuItem menuModifierEmplacement) {
		this.menuModifierEmplacement = menuModifierEmplacement;
	}
	/**
	 * @return the menuListeEmplacement
	 */
	public JMenuItem getMenuListeEmplacement() {
		return menuListeEmplacement;
	}
	/**
	 * @param menuListeEmplacement the menuListeEmplacement to set
	 */
	public void setMenuListeEmplacement(JMenuItem menuListeEmplacement) {
		this.menuListeEmplacement = menuListeEmplacement;
	}
	/**
	 * @return the menuBienvenue
	 */
	public JMenuItem getMenuBienvenue() {
		return menuBienvenue;
	}
	/**
	 * @param menuBienvenue the menuBienvenue to set
	 */
	public void setMenuBienvenue(JMenuItem menuBienvenue) {
		this.menuBienvenue = menuBienvenue;
	}
	/**
	 * @return the menuAPropos
	 */
	public JMenuItem getMenuAPropos() {
		return menuAPropos;
	}
	/**
	 * @param menuAPropos the menuAPropos to set
	 */
	public void setMenuAPropos(JMenuItem menuAPropos) {
		this.menuAPropos = menuAPropos;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private Fenetre 		fenetre;
	// Menu principaux
	private JMenu 	  		menuDechets;
	private JMenu	  		menuCollecteurs;
	private JMenu	  		menuEmplacements;
	private JMenu	  		menuHelp;
	private JMenu	  		menuAide;
	// Composants sous-menus	
	private JMenuItem menuCreerDechets;
	private JMenuItem menuModifierDechets;
	private JMenuItem menuListerDechets;

	private JMenuItem menuCreerCollecteur;
	private JMenuItem menuModifierCollecteur;
	private JMenuItem menuListeCollecteur;

	private JMenu menuCreerEmplacement;
	private JMenuItem menuModifierEmplacement;
	private JMenuItem menuListeEmplacement;
	
	private JMenuItem menuBienvenue;
	private JMenuItem menuAPropos;
	private JMenuItem menuCreerEmplacementDistributeur;
	private JMenuItem menuCreerEmplacementDechetterie;
	private JMenuItem menuCreerEmplacementExterne;
	/**
	 * 
	 */
	public MenuAppli(Fenetre fenetre) {
		super();
		// TODO Auto-generated constructor stub
		menuDechets 		= new JMenu ("Déchets");
		menuDechets.setMnemonic ('D');
		menuCollecteurs 	= new JMenu ("Collecteurs");
		menuCollecteurs.setMnemonic ('C');
		menuEmplacements	= new JMenu ("Localisations");
		menuEmplacements.setMnemonic ('L');
		menuHelp			= new JMenu ("Aides");
		menuHelp.setMnemonic ('A');
		
		this.add(menuDechets);
		this.add(menuCollecteurs);
		this.add(menuEmplacements);
		this.add(menuHelp);
		
		menuCreerDechets 				= new JMenuItem("Créer", 'C');
		menuModifierDechets   			= new JMenuItem("Modifier",'M');
		menuListerDechets   			= new JMenuItem("Lister",'L');
		
		menuDechets.add (menuCreerDechets);
		menuDechets.add (menuModifierDechets);
		menuDechets.add (menuListerDechets);
		
		menuCreerCollecteur 			= new JMenuItem("Créer", 'C');
		menuModifierCollecteur  		= new JMenuItem("Modifier",'M');
		menuListeCollecteur  			= new JMenuItem("Lister",'L');
		
		menuCollecteurs.add (menuCreerCollecteur);
		menuCollecteurs.add (menuModifierCollecteur);
		menuCollecteurs.add (menuListeCollecteur);
		

		menuCreerEmplacement 				= new JMenu("Créer");
		menuCreerEmplacementDistributeur 	= new JMenuItem("Distributeur", 'D');
		menuCreerEmplacementDechetterie 	= new JMenuItem("Déchetterie", 'T');
		menuCreerEmplacementExterne 		= new JMenuItem("Endroit externe", 'T');
		menuModifierEmplacement  			= new JMenuItem("Modifier",'M');
		menuListeEmplacement  				= new JMenuItem("Lister",'L');
		
		menuEmplacements.add (menuCreerEmplacement);
		menuCreerEmplacement.add(menuCreerEmplacementDistributeur);
		menuCreerEmplacement.add(menuCreerEmplacementDechetterie);
		menuCreerEmplacement.add(menuCreerEmplacementExterne);
		menuEmplacements.add (menuModifierEmplacement );
		menuEmplacements.add (menuListeEmplacement);
		
		
		
		menuBienvenue					= new JMenuItem("Bienvenue");
		menuAPropos 					= new JMenuItem("APropos");
		
		menuHelp.add (menuBienvenue);
		menuHelp.add (menuAPropos);
		menuHelp.add (mnuFichierQuitter);
		
		menuCreerCollecteur.addActionListener(this);
		menuModifierCollecteur.addActionListener(this);
		menuListeCollecteur.addActionListener(this);
		mnuFichierQuitter.setEnabled(true); // Le menu est grisé
		menuListeEmplacement.addActionListener(this);
		menuHelp.addActionListener(this);
		
		
		menuCreerEmplacementDechetterie.addActionListener(this);
		
		mnuFichierQuitter.setEnabled(true); // Le menu est grisé
		mnuFichierQuitter.addActionListener(this); // ABONNEMENT
		
	}
	
	
	private void mnuFichierQuitter_click()
	{
	System.exit(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (e.getSource() == mnuFichierQuitter) mnuFichierQuitter_click();
		if (source==menuCreerCollecteur){
			FenetreDecheterie fenetreDecheterie = new FenetreDecheterie();
		}
		if (source==menuModifierCollecteur){
			FenetreDecheterie fenetreDecheterie = new FenetreDecheterie();
		}				
		if (source==menuListeCollecteur){
			FenetreDecheterie fenetreDecheterie = new FenetreDecheterie();
		}
		if (source==menuListeEmplacement){
			fenetreListLieux = new FenetreListLieux();
			fenetreListLieux.pack();
			fenetreListLieux.setVisible(true);
		}
		
		if  (source==menuCreerEmplacementDechetterie){
			FenetreCreateLieu fenetreCreateLieu = new FenetreCreateLieu(new EmplacementDechetterie(0,0,null,"","",null,0.0F,0.0F,"",true));
			fenetreCreateLieu.pack();
			fenetreCreateLieu.setVisible(true);
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

		
	}
	

}
