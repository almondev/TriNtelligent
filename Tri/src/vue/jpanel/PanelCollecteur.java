/**
 * 
 */
package vue.jpanel;


import java.awt.FlowLayout;

import java.util.Iterator;


import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.glass.events.KeyEvent;

import control.AppActionListener;
import dao.Datas;
import metier.decheterie.Lieu;
import net.miginfocom.swing.MigLayout;
import vue.Fenetre;



/**
 * @author Mehdi HAMDI
 *
 */
public class PanelCollecteur extends PanelAppli {

	/**
	 * @return the txtDateCreation
	 */
	public JTextField getTxtDateCreation() {
		return txtDateCreation;
	}
	/**
	 * @param txtDateCreation the txtDateCreation to set
	 */
	public void setTxtDateCreation(JTextField txtDateCreation) {
		this.txtDateCreation = txtDateCreation;
	}
	/**
	 * @return the txtNomFabricant
	 */
	public JTextField getTxtNomFabricant() {
		return txtNomFabricant;
	}
	/**
	 * @param txtNomFabricant the txtNomFabricant to set
	 */
	public void setTxtNomFabricant(JTextField txtNomFabricant) {
		this.txtNomFabricant = txtNomFabricant;
	}
	/**
	 * @return the txtRefFabricant
	 */
	public JTextField getTxtRefFabricant() {
		return txtRefFabricant;
	}
	/**
	 * @param txtRefFabricant the txtRefFabricant to set
	 */
	public void setTxtRefFabricant(JTextField txtRefFabricant) {
		this.txtRefFabricant = txtRefFabricant;
	}
	/**
	 * @return the txt1
	 */
	public JTextField getTxt1() {
		return txtNomCollecteur;
	}
	/**
	 * @param txt1 the txt1 to set
	 */
	public void setTxt1(JTextField txt1) {
		this.txtNomCollecteur = txt1;
	}
	/**
	 * @return the txt2
	 */
	public JTextField getTxt2() {
		return txtDateCreation;
	}
	/**
	 * @param txt2 the txt2 to set
	 */
	public void setTxt2(JTextField txt2) {
		this.txtDateCreation = txt2;
	}


	/**
	 * @return the txt5
	 */
	public JTextField getTxt5() {
		return txt5;
	}
	/**
	 * @param txt5 the txt5 to set
	 */
	public void setTxt5(JTextField txt5) {
		this.txt5 = txt5;
	}
	/**
	 * @return the txt6
	 */
	public JTextField getTxt6() {
		return txt6;
	}
	/**
	 * @param txt6 the txt6 to set
	 */
	public void setTxt6(JTextField txt6) {
		this.txt6 = txt6;
	}
	/**
	 * @return the cboLieu
	 */
	public JComboBox<String> getCboLieu() {
		return cboLieu;
	}
	/**
	 * @param cboLieu the cboLieu to set
	 */
	public void setCboLieu(JComboBox<String> cboLieu) {
		this.cboLieu = cboLieu;
	}
	/**
	 * @return the groupProduit
	 */
	public ButtonGroup getGroupProduit() {
		return groupProduit;
	}
	/**
	 * @param groupProduit the groupProduit to set
	 */
	public void setGroupProduit(ButtonGroup groupProduit) {
		this.groupProduit = groupProduit;
	}
	/**
	 * @return the radioVert
	 */
	public JRadioButton getRadioVert() {
		return radioVert;
	}
	/**
	 * @param radioVert the radioVert to set
	 */
	public void setRadioVert(JRadioButton radioVert) {
		this.radioVert = radioVert;
	}
	/**
	 * @return the radioJaune
	 */
	public JRadioButton getRadioJaune() {
		return radioJaune;
	}
	/**
	 * @param radioJaune the radioJaune to set
	 */
	public void setRadioJaune(JRadioButton radioJaune) {
		this.radioJaune = radioJaune;
	}
	/**
	 * @return the radioMarron
	 */
	public JRadioButton getRadioMarron() {
		return radioMarron;
	}
	/**
	 * @param radioMarron the radioMarron to set
	 */
	public void setRadioMarron(JRadioButton radioMarron) {
		this.radioMarron = radioMarron;
	}
	/**
	 * @return the groupCollecteur
	 */
	public ButtonGroup getGroupCollecteur() {
		return groupCollecteur;
	}
	/**
	 * @param groupCollecteur the groupCollecteur to set
	 */
	public void setGroupCollecteur(ButtonGroup groupCollecteur) {
		this.groupCollecteur = groupCollecteur;
	}
	/**
	 * @return the radioColonne
	 */
	public JRadioButton getRadioColonne() {
		return radioColonne;
	}
	/**
	 * @param radioColonne the radioColonne to set
	 */
	public void setRadioColonne(JRadioButton radioColonne) {
		this.radioColonne = radioColonne;
	}
	/**
	 * @return the radioBoite
	 */
	public JRadioButton getRadioBoite() {
		return radioBoite;
	}
	/**
	 * @param radioBoite the radioBoite to set
	 */
	public void setRadioBoite(JRadioButton radioBoite) {
		this.radioBoite = radioBoite;
	}
	/**
	 * @return the radioMeuble
	 */
	public JRadioButton getRadioMeuble() {
		return radioMeuble;
	}
	/**
	 * @param radioMeuble the radioMeuble to set
	 */
	public void setRadioMeuble(JRadioButton radioMeuble) {
		this.radioMeuble = radioMeuble;
	}
	/**
	 * @return the radioSac
	 */
	public JRadioButton getRadioSac() {
		return radioSac;
	}
	/**
	 * @param radioSac the radioSac to set
	 */
	public void setRadioSac(JRadioButton radioSac) {
		this.radioSac = radioSac;
	}
	/**
	 * @return the jpaCollecteur
	 */
	public JPanel getJpaCollecteur() {
		return jpaCollecteur;
	}
	/**
	 * @param jpaCollecteur the jpaCollecteur to set
	 */
	public void setJpaCollecteur(JPanel jpaCollecteur) {
		this.jpaCollecteur = jpaCollecteur;
	}
	/**
	 * @return the jpaProduit
	 */
	public JPanel getJpaProduit() {
		return jpaProduit;
	}
	/**
	 * @param jpaProduit the jpaProduit to set
	 */
	public void setJpaProduit(JPanel jpaProduit) {
		this.jpaProduit = jpaProduit;
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
	/**
	 * @return the txtArea
	 */
	public JTextArea getTxtArea() {
		return txtArea;
	}
	/**
	 * @param txtArea the txtArea to set
	 */
	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
	}
	private JTextField txtNomCollecteur; //Nom collecteur
	private JTextField txtDateCreation; //ref :
	private JTextField txtNomFabricant; //Date création:
	private JTextField txtRefFabricant; //Type de déchet :
	private JTextField txt5; //Lieu : 
	private JTextField txt6; //Descriptif : 

	private JComboBox<String> cboLieu;
	// Pour état
	private ButtonGroup 	groupProduit;
	private JRadioButton 	radioVert;
	private JRadioButton 	radioJaune;
	private JRadioButton 	radioMarron;
	private ButtonGroup 	groupCollecteur;
	private JRadioButton 	radioColonne;
	private JRadioButton 	radioBoite;
	private JRadioButton 	radioMeuble;
	private JRadioButton 	radioSac;

	JPanel jpaCollecteur;
	JPanel jpaProduit;

	String choixProduit 	="";	// choix du produit

	String choixCollecteur  = "Colonne"; // choix collecteur
	private JTextArea txtArea;



	/**
	 * 
	 */
	public PanelCollecteur(Fenetre fenetre) {
		super(fenetre);
		choixProduit    = "Vert";
		choixCollecteur = "Colonne";
		prepareGUI();
	}
	private void prepareGUI(){




		this.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][][]"));


		JLabel lblNomCollecteur 					= new JLabel("Nom collecteur : ");
		JLabel lblDechet 							= new JLabel("Déchet :");
		JLabel lblDateCreation						= new JLabel("Date de création : ");
		JLabel lblNomFabricant 						= new JLabel("Nom du fabricant : ");
		JLabel lblRefFabricant 						= new JLabel("référence du fabricant: ");
		JLabel lblLieu								= new JLabel("Emplacement : ");
		JLabel lblOptions 							= new JLabel("Options : ");
		JLabel lblEtatCollecteur					= new JLabel("Etat du collecteur : ");
		JLabel lbl8									= new JLabel("Produit Vert: ");
		JLabel lbl9									= new JLabel("Produit Jaune: ");
		JLabel lbl10								= new JLabel("Produit Marron: ");
		JLabel lbl11					= new JLabel("Adresse : ");

		txtNomCollecteur 				= new JTextField(20);

		txtDateCreation 				= new JTextField(20);
		txtNomFabricant 							= new JTextField(20);
		txtRefFabricant							= new JTextField(20);
		txt5						
		= new JTextField(20);
		txt6							= new JTextField(20);
		cboLieu 						= new JComboBox<String>();
		txtArea							= new JTextArea(5, 20);
		this.add(lblNomCollecteur,   "cell 0 0");
		this.add(txtNomCollecteur,   "cell 1 0");
		this.add(lblDechet,  "cell 0 1");
		//this.add(txtDateCreation,  "cell 1 1");
		groupProduit = new ButtonGroup();

		radioVert = new JRadioButton(Datas.getProduits().get(0).getNomProduit(), true);
		radioVert.setMnemonic(KeyEvent.VK_1);
		radioVert.setActionCommand("Vert");
		radioJaune = new JRadioButton(Datas.getProduits().get(1).getNomProduit());
		radioJaune.setMnemonic(KeyEvent.VK_2);
		radioJaune.setActionCommand("Jaune");
		radioMarron = new JRadioButton(Datas.getProduits().get(2).getNomProduit());
		radioMarron.setMnemonic(KeyEvent.VK_3);
		radioMarron.setActionCommand("Marron");
		groupProduit.add(radioVert);
		groupProduit.add(radioJaune);
		groupProduit.add(radioMarron);
		jpaProduit		= new JPanel();
		jpaProduit.setLayout(new FlowLayout());
		this.add(jpaProduit,"cell 0 2 2 1");

		jpaProduit.add(radioVert);
		jpaProduit.add(radioJaune);
		jpaProduit.add(radioMarron);

		radioVert.addActionListener(new AppActionListener(getFenetre()));
		radioJaune.addActionListener(new AppActionListener(getFenetre()));
		radioMarron.addActionListener(new AppActionListener(getFenetre()));


		this.add(lblDateCreation,  "cell 0 3");
		this.add(txtDateCreation ,  "cell 1 3");
		this.add(lblNomFabricant,  "cell 0 4");
		this.add(txtNomFabricant,  "cell 1 4");
		this.add(lblRefFabricant,  "cell 0 5");
		this.add(txtRefFabricant,   "cell 1 5");
		this.add(lblLieu,"cell 0 6");
		Iterator<Lieu> itrTheme= Datas.getLieux().iterator();
		int tailleLieux=Datas.getLieux().size();
		String []libelleLieu = new String[tailleLieux];
		int indexLieu=0;
		while(itrTheme.hasNext()){
			libelleLieu[indexLieu] = ""+itrTheme.next().toString();
			//.getNumero()+" "
			//		+itrTheme.next().getAdresse();//+" "+
			//							itrTheme.next().getComplementAdresse()+" "+
			//							itrTheme.next().getCommune();
			indexLieu++;
		}
		//			    cboLieu.setModel(new DefaultComboBoxModel<String>(new String[] {"Musique", "Aventure", "Fiction", "Informatique", "Ludique"}));
		cboLieu.setModel(new DefaultComboBoxModel<String>(libelleLieu));
		this.add(cboLieu,"cell 1 6");

		this.add(txt6, "cell 1 6");

		this.add(txtArea,"cell 0 8 2 1");
		// TODO Auto-generated constructor stub







		jpaCollecteur 	= new JPanel();
		jpaCollecteur.setLayout(new FlowLayout());
		this.add(jpaCollecteur,"cell 0 9 2 1");




		groupCollecteur = new ButtonGroup();
		radioColonne	= new JRadioButton("Colonne",true);
		radioColonne.setMnemonic(KeyEvent.VK_4);
		radioColonne.setActionCommand("collec_1");
		radioBoite		= new JRadioButton("Boite");
		radioBoite.setMnemonic(KeyEvent.VK_5);
		radioBoite.setActionCommand("collec_2");
		radioMeuble		= new JRadioButton("Meuble");
		radioMeuble.setMnemonic(KeyEvent.VK_6);
		radioMeuble.setActionCommand("collec_3");			
		radioSac		= new JRadioButton("Sac");
		radioSac.setMnemonic(KeyEvent.VK_7);
		radioSac.setActionCommand("collec_4");

		groupCollecteur.add(radioColonne);
		groupCollecteur.add(radioBoite);
		groupCollecteur.add(radioMeuble);
		groupCollecteur.add(radioSac);

		jpaCollecteur.add(radioColonne);
		jpaCollecteur.add(radioBoite);
		jpaCollecteur.add(radioMeuble);
		jpaCollecteur.add(radioSac);

		radioColonne.addActionListener(new AppActionListener(getFenetre()));
		radioSac.addActionListener(new AppActionListener(getFenetre()));
		radioMeuble.addActionListener(new AppActionListener(getFenetre()));
		radioBoite.addActionListener(new AppActionListener(getFenetre()));
	}
	/**
	 * @return the txtNomCollecteur
	 */
	public JTextField getTxtNomCollecteur() {
		return txtNomCollecteur;
	}
	/**
	 * @param txtNomCollecteur the txtNomCollecteur to set
	 */
	public void setTxtNomCollecteur(JTextField txtNomCollecteur) {
		this.txtNomCollecteur = txtNomCollecteur;
	}
	/**
	 * @return the choixProduit
	 */
	public String getChoixProduit() {
		return choixProduit;
	}
	/**
	 * @param choixProduit the choixProduit to set
	 */
	public void setChoixProduit(String choixProduit) {
		this.choixProduit = choixProduit;
	}
	/**
	 * @return the choixCollecteur
	 */
	public String getChoixCollecteur() {
		return choixCollecteur;
	}
	/**
	 * @param choixCollecteur the choixCollecteur to set
	 */
	public void setChoixCollecteur(String choixCollecteur) {
		this.choixCollecteur = choixCollecteur;
	}

}
