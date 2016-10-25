/**
 * 
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JTable;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

//Bibliothèque externes.
import net.miginfocom.swing.MigLayout;

import com.sun.glass.events.KeyEvent;

import control.AppActionListener;
import dao.CommuneDao;
import dao.Datas;
import dao.LieuDao;
import dao.VoieDAO;
import metier.decheterie.Commune;
import metier.decheterie.EmplacementDechetterie;
import metier.decheterie.EmplacementDistributeur;
import metier.decheterie.EmplacementExterne;
import metier.decheterie.Lieu;
import metier.decheterie.Voie;
import parametres.ConstantesEcran;



/**
 * @author Afpa
 *
 */
public class FenetreCreateLieu extends Fenetre {

	
	// panelEast
	private JTable 				jTableLieu;
	private DefaultTableModel 	modelLieu;

	// panelSouth
	private JButton 			cmdInsert;
	private JButton 			cmdUpdate;
	private JButton 			cmdDelete;
	private JButton 			cmdClear;
	private JButton				cmdSearch;
	//JLabel
	JLabel lblNumero;
	JLabel lblVoie;
	JLabel lblAdresse;
	JLabel lblComplementAdresse;
	JLabel lblCommune;
	JLabel lblLattitude;
	JLabel lblLongitude;
	JLabel lblNomDechetterie;
	JLabel lblOuvertWeekEnd;
	JLabel lblNombreMaxCollecteurs;
	JLabel lblNomDistributeur;
	
	// panelWest
	private JTextField 			txtNumero;
	private JComboBox<String> 	cboVoie;
	private JTextField 			txtAdresse;
	private JTextField 			txtComplementAdresse;
	private JComboBox<String> 	cboCommune;
	private JTextField		 	txtLattitude;
	private JTextField			txtLongitude;
	private JTextField 			txtNomDechetterie;
	private JCheckBox 			optOuvertWeekEnd;
	private JTextField 			txtNombreMaxCollecteurs;
	private JTextField 			txtNomDistributeur;	
	
	// Pour état
	ButtonGroup group;
    JRadioButton radioDistributeur;
    JRadioButton radioDechetterie;
    JRadioButton radioExterne;

	private String optionFenetre;
	private JLabel lblOption;
    
    private LieuDao lDao;
    private List<Lieu> listLieu;
    
    private String choixEmplacement="DECHETTERIE"; // DECHETTERIE OU 
    
	/**
	 * @throws HeadlessException
	 */
	public FenetreCreateLieu(Lieu lieu) throws HeadlessException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		setSize(new Dimension(1100,600));
		JPanel contentPane = (JPanel)getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//		contentPane.setBackground(ConstantesEcran.COULEUR_FOND);
		contentPane.setLayout(new BorderLayout(0, 20));		
		// TODO Auto-generated constructor stub
		if (lieu instanceof EmplacementExterne) {
			optionFenetre = "externe";
			
		} else if(lieu instanceof EmplacementDistributeur) {
			optionFenetre = "distributeur";
		} else {
			optionFenetre = "dechetterie";
		}
		
		//Création des boutons de SCRUD
		cmdClear = new JButton("Clear");
		cmdInsert = new JButton("Creation");
		cmdUpdate = new JButton("Modification");
		cmdDelete = new JButton("Suppression");
		// Construction du titre de la fenetre
		JLabel lblTitreN = new JLabel("Gestion des adresses", SwingConstants.CENTER);
		lblTitreN.setFont(ConstantesEcran.FONT_TITRE2);
		contentPane.add(lblTitreN, BorderLayout.NORTH);
		/*
		 * Construction de la zone des boutons - panelSouth
		 */
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		cmdClear  = new 	JButton("Effacer toutes les adresses");
		cmdInsert = new 	JButton("Creation");
		cmdUpdate = new 	JButton("Modification");
		cmdDelete = new 	JButton("Suppression");
		cmdSearch = new  	JButton("Rechercher adresse");

		panelSouth.add(cmdClear);		
		panelSouth.add(cmdInsert);		
		panelSouth.add(cmdUpdate);		
		panelSouth.add(cmdDelete);
		panelSouth.add(cmdSearch);
		
		
		
		//ActionListener:
		cmdClear.addActionListener(new AppActionListener(this));
		cmdInsert.addActionListener(new AppActionListener(this));
		cmdUpdate.addActionListener(new AppActionListener(this));
		cmdDelete.addActionListener(new AppActionListener(this));
		cmdSearch.addActionListener(new AppActionListener(this));
		/*
		 * Construction de la zone de saisie des adresses - panelWest
		 * ATT : à faire avant la liste de adresse 
		 *    car le modèle utilise les 
		 */		
		JPanel panelWest = new JPanel();
		panelWest.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(panelWest, BorderLayout.WEST);

		initPanelWest(panelWest);		
		

		
		/*
		 * Construction de la liste d'adresses - panelEast
		 */	
		JPanel panelEast = new JPanel();
		panelEast.setBorder(new LineBorder(Color.BLUE, 2, true));
		contentPane.add(panelEast, BorderLayout.CENTER);

		initPanelEast(panelEast);	
		//-----------Fin du programme ----------
	}

	private void initPanelWest(JPanel panelWest) {
		// TODO Auto-generated method stub
		panelWest.setLayout(new MigLayout("", "[][grow]", "[][][][][][][grow][grow]"));
		//JLabel
		lblNumero 					= new JLabel("Numéro :");
		lblVoie 						= new JLabel("Voie :");
		lblAdresse 					= new JLabel("Adresse :");
		lblComplementAdresse 		= new JLabel("Complement d'adresse : ");
		lblCommune 					= new JLabel("Commune : ");
		lblLattitude 				= new JLabel("Lattitude : ");
		lblLongitude 				= new JLabel("Longitude : ");
		//Label dépendant des emplacements
		lblOption					= new JLabel("Choix emplacement : ");
		
		lblNomDechetterie			= new JLabel("Nom déchetterie : ");
		lblOuvertWeekEnd			= new JLabel("Ouvert le week-end :");
		lblNombreMaxCollecteurs		= new JLabel("Nombre maximum de collecteur :");
		lblNomDistributeur			= new JLabel("Nom du distributeur :");	

		// panelWest
		txtNumero					= new JTextField();
		cboVoie 					= new JComboBox<String>();
		VoieDAO vDAO = new VoieDAO();
		int tailleVoies = vDAO.taille();
		System.out.println("taille de la voie = "+tailleVoies);
		String []libelleVoie = new String[tailleVoies];
		int indexVoie=0;
		List<Voie> listeVoies = (ArrayList<Voie>) vDAO.getAll();
		for (Voie v : listeVoies){
			libelleVoie[indexVoie] = v.getNomVoie();
			indexVoie++;
		}
//		indexVoie++;
//		Iterator<Voie> itrTheme= Datas.getVoies().iterator();
//		int tailleVoies=Datas.getVoies().size();
//		String []libelleVoie = new String[tailleVoies];
//		int indexVoie=0;
//		while(itrTheme.hasNext()){
//			libelleVoie[indexVoie] = itrTheme.next().getNomVoie();
//			indexVoie++;
//		}
		//cbTheme.setModel(new DefaultComboBoxModel<String>(new String[] {"Musique", "Aventure", "Fiction", "Informatique", "Ludique"}));
		cboVoie.setModel(new DefaultComboBoxModel<String>(libelleVoie));
		
		
		
		txtAdresse 					= new  JTextField();
		txtComplementAdresse 		= new JTextField();
		cboCommune 				= new JComboBox<String>();
//		Iterator<Commune> itrCommune= Datas.getCommunes().iterator();
//		int tailleCommunes=Datas.getCommunes().size();
//		String []libelleCommune = new String[tailleCommunes];
//		
//		int indexCommune=0;
//		while(itrCommune.hasNext()){
//			libelleCommune[indexCommune] = itrCommune.next().getNomCommune();
//			indexCommune++;
//		}
		CommuneDao cDAO = new CommuneDao();
		int tailleCommunes = cDAO.taille();
		System.out.println("taille de la voie = "+tailleCommunes);
		String []libelleCommune = new String[tailleCommunes];
		int indexCommune=0;
		List<Commune> listeCommunes = (ArrayList<Commune>) cDAO.getAll();
		for (Commune c : listeCommunes){
			libelleCommune[indexCommune] = c.getNomCommune();
			indexCommune++;
		}
		
		//cbTheme.setModel(new DefaultComboBoxModel<String>(new String[] {"Musique", "Aventure", "Fiction", "Informatique", "Ludique"}));
		cboCommune.setModel(new DefaultComboBoxModel<String>(libelleCommune));
		
		
		
		txtLattitude				= new JTextField();
		txtLongitude				= new JTextField();
		//Composant dependant des emplecaments
		txtNomDechetterie			= new JTextField();
		optOuvertWeekEnd			= new JCheckBox();
		txtNombreMaxCollecteurs		= new JTextField();
		txtNomDistributeur			= new JTextField();
		
		group = new ButtonGroup();
		radioDistributeur = new JRadioButton("Distributeur", true);
		radioDistributeur.setMnemonic(KeyEvent.VK_1);
		radioDistributeur.setActionCommand("Choix_1");
		radioDechetterie = new JRadioButton("Déchetterie");
		radioDechetterie.setMnemonic(KeyEvent.VK_2);
		radioDechetterie.setActionCommand("Choix_2");
		radioExterne = new JRadioButton("Emplacement externe");
		radioExterne.setMnemonic(KeyEvent.VK_3);
		radioExterne.setActionCommand("Choix_3");
	    
	    group.add(radioDistributeur);
	    group.add(radioDechetterie);
	    group.add(radioExterne);
	    //
	    
	    
	    //
		panelWest.add(lblNumero,   "cell 0 0,alignx trailing");
		panelWest.add(txtNumero,   "cell 1 0,growx");
		panelWest.add(lblVoie,  "cell 0 1,alignx trailing,aligny top");
		panelWest.add(cboVoie,  "cell 1 1,growx,aligny top");
		panelWest.add(lblAdresse,  "cell 0 2,alignx trailing");
		panelWest.add(txtAdresse,  "cell 1 2,growx,aligny top");
		panelWest.add(lblComplementAdresse,  "cell 0 3,alignx trailing");
		panelWest.add(txtComplementAdresse,  "cell 1 3,growx");
		panelWest.add(lblCommune,  "cell 0 4,alignx trailing");
		panelWest.add(cboCommune,   "cell 1 4,growx");
		panelWest.add(lblLattitude,"cell 0 5,alignx trailing");
		panelWest.add(txtLattitude, "cell 1 5,growx");

		panelWest.add(lblLongitude,   "cell 0 7");
		panelWest.add(txtLongitude,"cell 1 7,growx");

		panelWest.add(lblNomDechetterie, "cell 0 8,alignx trailing");
		panelWest.add(txtNomDechetterie,  "cell 1 8,growx");
		panelWest.add(lblOuvertWeekEnd, "cell 0 9,alignx trailing");
		panelWest.add(optOuvertWeekEnd,  "cell 1 9,growx,aligny top");
		panelWest.add(lblNomDistributeur, "cell 0 10,alignx trailing");
		panelWest.add(txtNomDistributeur,  "cell 1 10,growx,aligny top");		
		panelWest.add(lblNombreMaxCollecteurs, "cell 0 11,growx,aligny top");		
		panelWest.add(txtNombreMaxCollecteurs, "cell 1 11,growx,aligny top");
		panelWest.add(lblOption,  "cell 0 11,alignx trailing");
		panelWest.add(radioDistributeur, "cell 1 12,growx,aligny top");
		panelWest.add(radioDechetterie, "cell 1 13,growx,aligny top");
		panelWest.add(radioExterne,  "cell 1 14,growx,aligny top");
    

	    
	}

	private void initPanelEast(JPanel panelEast) {
		// TODO Auto-generated method stub
		// panneau scroll
		JScrollPane zoneTable;
				// tableau contenant les entete des colonne du composant JTable
				//		String [] cols = {"Type Emplacement","refLieu","Numéro", "Voie", "Adresse", "Complement adresse", "Commune", "Lattitude", "Longitude"};
		String [] cols = {"Type Emplacement","refLieu","Numéro", "Voie", "Adresse", "Complement adresse", "Commune", "Lattitude", "Longitude"};
				// creation du modèle (objet contenant les données de la JTable)
		modelLieu 	= new DefaultTableModel(cols, 0);

		
		jTableLieu = new JTable(modelLieu);
		
		lDao = new LieuDao();
		
		refreshJTableauAdresses();
		System.out.println("pannelEast");
		
		zoneTable = new JScrollPane(jTableLieu,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		zoneTable.setViewportBorder(new LineBorder(null, 2, true));
		//		zoneTable.setBorder(BorderFactory.createLineBorder(Color.PINK));
		zoneTable.setAutoscrolls(true); // default false

		panelEast.add(zoneTable);
	}
	

	public void refreshJTableauAdresses(){
		
		//Vider le JTable
		int rowCount = modelLieu.getRowCount();
		//System.out.println("taille :"+rowCount);
		for (int i = rowCount - 1; i >= 0; i--) {
			System.out.println("i"+i);
			modelLieu.removeRow(i);
		}
		
		listLieu= lDao.getAll();
		for(Lieu lieu : listLieu){
			if (lieu instanceof EmplacementDechetterie) {

				modelLieu.addRow( new Object[] {
						"DECHETTERIE",
						lieu.getRefLieu(),
						lieu.getNumero(),
						lieu.getVoie().getNomVoie(),
						lieu.getAdresse(),
						lieu.getComplementAdresse(),
						lieu.getCommune().getNomCommune(),
						lieu.getLattitude(),
						lieu.getLongitude()

				});
			}
			if (lieu instanceof EmplacementDistributeur) {

				modelLieu.addRow( new Object[] {
						"DISTRIBUTEUR",
						lieu.getRefLieu(),
						lieu.getNumero(),
						lieu.getVoie().getNomVoie(),
						lieu.getAdresse(),
						lieu.getComplementAdresse(),
						lieu.getCommune().getNomCommune(),
						lieu.getLattitude(),
						lieu.getLongitude()

				});
			}
			
			if (lieu instanceof EmplacementExterne) {

				modelLieu.addRow( new Object[] {
						"EXTERNE",
						lieu.getRefLieu(),
						lieu.getNumero(),
						lieu.getVoie().getNomVoie(),
						lieu.getAdresse(),
						lieu.getComplementAdresse(),
						lieu.getCommune().getNomCommune(),
						lieu.getLattitude(),
						lieu.getLongitude()

				});
			}
		}
		
//		for (int i = 0; i < 30; i++) {
//
//		
//			modelLieu.addRow( new Object[] {
//					"Ref"+i, 
//					"Description "+i, 
//					"titre"+i, 
//					"22/10/2013" , 
//					"objet A", 
//					"objet B", 
//					"objet C"});
//		} 
		initLargeurColonnes(jTableLieu);
		jTableLieu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTableLieu.setPreferredScrollableViewportSize(new Dimension(200,400)); 
	}

	private void initLargeurColonnes(JTable jTable) {
		TableColumn column = null;
		for (int i = 0; i < 7; i++) {
			column = jTable.getColumnModel().getColumn(i);
			switch (i) {

			case 0 : // cote
				column.setPreferredWidth(50); 
				break;
			case 1 : // description
				column.setPreferredWidth(100); 
				break;
			case 2 : // titre
				column.setPreferredWidth(70);
				break;
			case 3 : // date edition
				column.setPreferredWidth(100); 
				break;
			case 4 : // auteurs
				column.setPreferredWidth(300); 
				break;
			case 5 : // theme
				column.setPreferredWidth(100); 
				break;
			case 6 : // editeur
				column.setPreferredWidth(100); 
				break;
			default :
				column.setPreferredWidth(100);
			}
		}
	}

	/**
	 * @return the jTableLieu
	 */
	public JTable getjTableLieu() {
		return jTableLieu;
	}

	/**
	 * @param jTableLieu the jTableLieu to set
	 */
	public void setjTableLieu(JTable jTableLieu) {
		this.jTableLieu = jTableLieu;
	}

	/**
	 * @return the modelLieu
	 */
	public DefaultTableModel getModelLieu() {
		return modelLieu;
	}

	/**
	 * @param modelLieu the modelLieu to set
	 */
	public void setModelLieu(DefaultTableModel modelLieu) {
		this.modelLieu = modelLieu;
	}

	/**
	 * @return the cmdInsert
	 */
	public JButton getCmdInsert() {
		return cmdInsert;
	}

	/**
	 * @param cmdInsert the cmdInsert to set
	 */
	public void setCmdInsert(JButton cmdInsert) {
		this.cmdInsert = cmdInsert;
	}

	/**
	 * @return the cmdUpdate
	 */
	public JButton getCmdUpdate() {
		return cmdUpdate;
	}

	/**
	 * @param cmdUpdate the cmdUpdate to set
	 */
	public void setCmdUpdate(JButton cmdUpdate) {
		this.cmdUpdate = cmdUpdate;
	}

	/**
	 * @return the cmdDelete
	 */
	public JButton getCmdDelete() {
		return cmdDelete;
	}

	/**
	 * @param cmdDelete the cmdDelete to set
	 */
	public void setCmdDelete(JButton cmdDelete) {
		this.cmdDelete = cmdDelete;
	}

	/**
	 * @return the cmdClear
	 */
	public JButton getCmdClear() {
		return cmdClear;
	}

	/**
	 * @param cmdClear the cmdClear to set
	 */
	public void setCmdClear(JButton cmdClear) {
		this.cmdClear = cmdClear;
	}

	/**
	 * @return the cmdSearch
	 */
	public JButton getCmdSearch() {
		return cmdSearch;
	}

	/**
	 * @param cmdSearch the cmdSearch to set
	 */
	public void setCmdSearch(JButton cmdSearch) {
		this.cmdSearch = cmdSearch;
	}

	/**
	 * @return the lblNumero
	 */
	public JLabel getLblNumero() {
		return lblNumero;
	}

	/**
	 * @param lblNumero the lblNumero to set
	 */
	public void setLblNumero(JLabel lblNumero) {
		this.lblNumero = lblNumero;
	}

	/**
	 * @return the lblVoie
	 */
	public JLabel getLblVoie() {
		return lblVoie;
	}

	/**
	 * @param lblVoie the lblVoie to set
	 */
	public void setLblVoie(JLabel lblVoie) {
		this.lblVoie = lblVoie;
	}

	/**
	 * @return the lblAdresse
	 */
	public JLabel getLblAdresse() {
		return lblAdresse;
	}

	/**
	 * @param lblAdresse the lblAdresse to set
	 */
	public void setLblAdresse(JLabel lblAdresse) {
		this.lblAdresse = lblAdresse;
	}

	/**
	 * @return the lblComplementAdresse
	 */
	public JLabel getLblComplementAdresse() {
		return lblComplementAdresse;
	}

	/**
	 * @param lblComplementAdresse the lblComplementAdresse to set
	 */
	public void setLblComplementAdresse(JLabel lblComplementAdresse) {
		this.lblComplementAdresse = lblComplementAdresse;
	}

	/**
	 * @return the lblCommune
	 */
	public JLabel getLblCommune() {
		return lblCommune;
	}

	/**
	 * @param lblCommune the lblCommune to set
	 */
	public void setLblCommune(JLabel lblCommune) {
		this.lblCommune = lblCommune;
	}

	/**
	 * @return the lblLattitude
	 */
	public JLabel getLblLattitude() {
		return lblLattitude;
	}

	/**
	 * @param lblLattitude the lblLattitude to set
	 */
	public void setLblLattitude(JLabel lblLattitude) {
		this.lblLattitude = lblLattitude;
	}

	/**
	 * @return the lblLongitude
	 */
	public JLabel getLblLongitude() {
		return lblLongitude;
	}

	/**
	 * @param lblLongitude the lblLongitude to set
	 */
	public void setLblLongitude(JLabel lblLongitude) {
		this.lblLongitude = lblLongitude;
	}

	/**
	 * @return the lblNomDechetterie
	 */
	public JLabel getLblNomDechetterie() {
		return lblNomDechetterie;
	}

	/**
	 * @param lblNomDechetterie the lblNomDechetterie to set
	 */
	public void setLblNomDechetterie(JLabel lblNomDechetterie) {
		this.lblNomDechetterie = lblNomDechetterie;
	}

	/**
	 * @return the lblOuvertWeekEnd
	 */
	public JLabel getLblOuvertWeekEnd() {
		return lblOuvertWeekEnd;
	}

	/**
	 * @param lblOuvertWeekEnd the lblOuvertWeekEnd to set
	 */
	public void setLblOuvertWeekEnd(JLabel lblOuvertWeekEnd) {
		this.lblOuvertWeekEnd = lblOuvertWeekEnd;
	}

	/**
	 * @return the lblNombreMaxCollecteurs
	 */
	public JLabel getLblNombreMaxCollecteurs() {
		return lblNombreMaxCollecteurs;
	}

	/**
	 * @param lblNombreMaxCollecteurs the lblNombreMaxCollecteurs to set
	 */
	public void setLblNombreMaxCollecteurs(JLabel lblNombreMaxCollecteurs) {
		this.lblNombreMaxCollecteurs = lblNombreMaxCollecteurs;
	}

	/**
	 * @return the lblNomDistributeur
	 */
	public JLabel getLblNomDistributeur() {
		return lblNomDistributeur;
	}

	/**
	 * @param lblNomDistributeur the lblNomDistributeur to set
	 */
	public void setLblNomDistributeur(JLabel lblNomDistributeur) {
		this.lblNomDistributeur = lblNomDistributeur;
	}

	/**
	 * @return the txtNumero
	 */
	public JTextField getTxtNumero() {
		return txtNumero;
	}

	/**
	 * @param txtNumero the txtNumero to set
	 */
	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}

	/**
	 * @return the cboVoie
	 */
	public JComboBox<String> getCboVoie() {
		return cboVoie;
	}

	/**
	 * @param cboVoie the cboVoie to set
	 */
	public void setCboVoie(JComboBox<String> cboVoie) {
		this.cboVoie = cboVoie;
	}

	/**
	 * @return the txtAdresse
	 */
	public JTextField getTxtAdresse() {
		return txtAdresse;
	}

	/**
	 * @param txtAdresse the txtAdresse to set
	 */
	public void setTxtAdresse(JTextField txtAdresse) {
		this.txtAdresse = txtAdresse;
	}

	/**
	 * @return the txtComplementAdresse
	 */
	public JTextField getTxtComplementAdresse() {
		return txtComplementAdresse;
	}

	/**
	 * @param txtComplementAdresse the txtComplementAdresse to set
	 */
	public void setTxtComplementAdresse(JTextField txtComplementAdresse) {
		this.txtComplementAdresse = txtComplementAdresse;
	}

	/**
	 * @return the cboCommune
	 */
	public JComboBox<String> getCboCommune() {
		return cboCommune;
	}

	/**
	 * @param cboCommune the cboCommune to set
	 */
	public void setCboCommune(JComboBox<String> cboCommune) {
		this.cboCommune = cboCommune;
	}

	/**
	 * @return the txtLattitude
	 */
	public JTextField getTxtLattitude() {
		return txtLattitude;
	}

	/**
	 * @param txtLattitude the txtLattitude to set
	 */
	public void setTxtLattitude(JTextField txtLattitude) {
		this.txtLattitude = txtLattitude;
	}

	/**
	 * @return the txtLongitude
	 */
	public JTextField getTxtLongitude() {
		return txtLongitude;
	}

	/**
	 * @param txtLongitude the txtLongitude to set
	 */
	public void setTxtLongitude(JTextField txtLongitude) {
		this.txtLongitude = txtLongitude;
	}

	/**
	 * @return the txtNomDechetterie
	 */
	public JTextField getTxtNomDechetterie() {
		return txtNomDechetterie;
	}

	/**
	 * @param txtNomDechetterie the txtNomDechetterie to set
	 */
	public void setTxtNomDechetterie(JTextField txtNomDechetterie) {
		this.txtNomDechetterie = txtNomDechetterie;
	}

	/**
	 * @return the optOuvertWeekEnd
	 */
	public JCheckBox getOptOuvertWeekEnd() {
		return optOuvertWeekEnd;
	}

	/**
	 * @param optOuvertWeekEnd the optOuvertWeekEnd to set
	 */
	public void setOptOuvertWeekEnd(JCheckBox optOuvertWeekEnd) {
		this.optOuvertWeekEnd = optOuvertWeekEnd;
	}

	/**
	 * @return the txtNombreMaxCollecteurs
	 */
	public JTextField getTxtNombreMaxCollecteurs() {
		return txtNombreMaxCollecteurs;
	}

	/**
	 * @param txtNombreMaxCollecteurs the txtNombreMaxCollecteurs to set
	 */
	public void setTxtNombreMaxCollecteurs(JTextField txtNombreMaxCollecteurs) {
		this.txtNombreMaxCollecteurs = txtNombreMaxCollecteurs;
	}

	/**
	 * @return the txtNomDistributeur
	 */
	public JTextField getTxtNomDistributeur() {
		return txtNomDistributeur;
	}

	/**
	 * @param txtNomDistributeur the txtNomDistributeur to set
	 */
	public void setTxtNomDistributeur(JTextField txtNomDistributeur) {
		this.txtNomDistributeur = txtNomDistributeur;
	}

	/**
	 * @return the group
	 */
	public ButtonGroup getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	/**
	 * @return the radioDistributeur
	 */
	public JRadioButton getRadioDistributeur() {
		return radioDistributeur;
	}

	/**
	 * @param radioDistributeur the radioDistributeur to set
	 */
	public void setRadioDistributeur(JRadioButton radioDistributeur) {
		this.radioDistributeur = radioDistributeur;
	}

	/**
	 * @return the radioDechetterie
	 */
	public JRadioButton getRadioDechetterie() {
		return radioDechetterie;
	}

	/**
	 * @param radioDechetterie the radioDechetterie to set
	 */
	public void setRadioDechetterie(JRadioButton radioDechetterie) {
		this.radioDechetterie = radioDechetterie;
	}

	/**
	 * @return the radioExterne
	 */
	public JRadioButton getRadioExterne() {
		return radioExterne;
	}

	/**
	 * @param radioExterne the radioExterne to set
	 */
	public void setRadioExterne(JRadioButton radioExterne) {
		this.radioExterne = radioExterne;
	}

	/**
	 * @return the optionFenetre
	 */
	public String getOptionFenetre() {
		return optionFenetre;
	}

	/**
	 * @param optionFenetre the optionFenetre to set
	 */
	public void setOptionFenetre(String optionFenetre) {
		this.optionFenetre = optionFenetre;
	}

	/**
	 * @return the lblOption
	 */
	public JLabel getLblOption() {
		return lblOption;
	}

	/**
	 * @param lblOption the lblOption to set
	 */
	public void setLblOption(JLabel lblOption) {
		this.lblOption = lblOption;
	}

	/**
	 * @return the lDao
	 */
	public LieuDao getlDao() {
		return lDao;
	}

	/**
	 * @param lDao the lDao to set
	 */
	public void setlDao(LieuDao lDao) {
		this.lDao = lDao;
	}

	/**
	 * @return the listLieu
	 */
	public List<Lieu> getListLieu() {
		return listLieu;
	}

	/**
	 * @param listLieu the listLieu to set
	 */
	public void setListLieu(List<Lieu> listLieu) {
		this.listLieu = listLieu;
	}

	/**
	 * @return the choixEmplacement
	 */
	public String getChoixEmplacement() {
		return choixEmplacement;
	}

	/**
	 * @param choixEmplacement the choixEmplacement to set
	 */
	public void setChoixEmplacement(String choixEmplacement) {
		this.choixEmplacement = choixEmplacement;
	}



}
