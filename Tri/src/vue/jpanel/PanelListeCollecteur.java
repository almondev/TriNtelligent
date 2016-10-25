/**
 * 
 */
package vue.jpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import control.AppActionListener;
import dao.Datas;
import vue.Fenetre;


/**
 * @author Mehdi HAMDI
 *
 */
public class PanelListeCollecteur extends PanelAppli {

	/**
	 * @return the jTableCollecteurs
	 */
	public JTable getjTableCollecteurs() {
		return jTableCollecteurs;
	}



	/**
	 * @param jTableCollecteurs the jTableCollecteurs to set
	 */
	public void setjTableCollecteurs(JTable jTableCollecteurs) {
		this.jTableCollecteurs = jTableCollecteurs;
	}



	/**
	 * @return the btnClear
	 */
	public JButton getBtnClear() {
		return btnClear;
	}



	/**
	 * @param btnClear the btnClear to set
	 */
	public void setBtnClear(JButton btnClear) {
		this.btnClear = btnClear;
	}



	/**
	 * @return the btnInsert
	 */
	public JButton getBtnInsert() {
		return btnInsert;
	}



	/**
	 * @param btnInsert the btnInsert to set
	 */
	public void setBtnInsert(JButton btnInsert) {
		this.btnInsert = btnInsert;
	}



	/**
	 * @return the btnUpdate
	 */
	public JButton getBtnUpdate() {
		return btnUpdate;
	}



	/**
	 * @param btnUpdate the btnUpdate to set
	 */
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}



	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}



	/**
	 * @param btnDelete the btnDelete to set
	 */
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}



	/**
	 * @return the listeCollecteurs
	 */
	public DefaultTableModel getListeCollecteurs() {
		return listeCollecteurs;
	}



	/**
	 * @param listeCollecteurs the listeCollecteurs to set
	 */
	public void setListeCollecteurs(DefaultTableModel listeCollecteurs) {
		this.listeCollecteurs = listeCollecteurs;
	}



	/**
	 * @return the jtListeLivres
	 */
	public JTable getJtListeLivres() {
		return jTableCollecteurs;
	}



	/**
	 * @param jtListeLivres the jtListeLivres to set
	 */
	public void setJtListeLivres(JTable jtListeLivres) {
		this.jTableCollecteurs = jtListeLivres;
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
	private DefaultTableModel listeCollecteurs;
	private JTable jTableCollecteurs;
	private JButton btnClear;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	


	/**
	 * 
	 */
	public PanelListeCollecteur(Fenetre fenetre) {
		super(fenetre);
		// TODO Auto-generated constructor stub
		// panneau scroll
		JScrollPane zoneTable;
		// tableau contenant les entete des colonne du composant JTable
		//		String [] cols = {"Cote", "Description", "Titre", "Date Edition", "Auteur(s)", "Theme", "Editeur",};
		String [] cols = {"Nom Collecteur", "Produit","Type Collecteur","Date création", "index Fabricant", "Ref Fabricant", "Emplacement"};
		// creation du modèle (objet contenant les données de la JTable)
		listeCollecteurs 	= new DefaultTableModel(cols, 0);

		// creation de l'objet JTable à partir du modèle
		jTableCollecteurs 	= new JTable(listeCollecteurs);
		jTableCollecteurs.setPreferredScrollableViewportSize(new Dimension(400,200)); 
		
		zoneTable = new JScrollPane(jTableCollecteurs,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		zoneTable.setViewportBorder(new LineBorder(null, 2, true));
		//		zoneTable.setBorder(BorderFactory.createLineBorder(Color.PINK));
		zoneTable.setAutoscrolls(true); // default false
		JPanel panelNorth = new JPanel();
		this.add(panelNorth, BorderLayout.NORTH);
		panelNorth.add(zoneTable);
		
		JPanel panelSouth = new JPanel();
		this.add(panelSouth, BorderLayout.SOUTH);



		btnClear = new JButton("Clear");
		btnInsert = new JButton("Creation");
		btnUpdate = new JButton("Modification");
		btnDelete = new JButton("Suppression");


		panelSouth.add(btnClear);		
		panelSouth.add(btnInsert);		
		panelSouth.add(btnUpdate);		
		panelSouth.add(btnDelete);
		
		

		btnInsert.addActionListener(new AppActionListener(fenetre));
		btnClear.addActionListener(new AppActionListener(fenetre));
		btnUpdate.addActionListener(new AppActionListener(fenetre));
		btnDelete.addActionListener(new AppActionListener(fenetre));
		
;
		
		refreshJTableauCollecteurs();
	}

	private void initLargeurColonnes(JTable jtListe2) {
		TableColumn column = null;
		for (int i = 0; i < 6; i++) {
			column = jTableCollecteurs.getColumnModel().getColumn(i);
			switch (i) {

			case 0 : // Nom Collecteur
				column.setPreferredWidth(50); 
				break;
			case 1 : // Produit
				column.setPreferredWidth(100); 
				break;
			case 2 : // Type Collecteur
				column.setPreferredWidth(70);
				break;
			case 3 : // Date création
				column.setPreferredWidth(100); 
				break;
			case 4 : // index Fabricant
				column.setPreferredWidth(300); 
				break;
			case 5 : // Ref Fabricant
				column.setPreferredWidth(100); 
				break;
			case 6 : // Emplacement
				column.setPreferredWidth(100); 
				break;
			default :
				column.setPreferredWidth(100);
			}
		}
	}

	public void refreshJTableauCollecteurs() {
		// TODO Auto-generated method stub
//		for (int i = 0; i < 130; i++){
//			this.getListeCollecteurs().addRow(new Object[] {"collecteur_"+i,"Produit vert","Boite","10/09/2016","index01","ref0125","Lieu0122"});
//		}
		int rowCount = listeCollecteurs.getRowCount();
		System.out.println("taille :"+rowCount);
		for (int i = rowCount - 1; i >= 0; i--) {
			System.out.println("i"+i);
			listeCollecteurs.removeRow(i);
			// System.out.println("*** " + this.getListLivre().getRowCount() + " " + i);
		}
		for (int i=0; i < Datas.getCollecteurs().size() ; i++){
			getListeCollecteurs().addRow( new Object[] {					
					Datas.getCollecteurs().get(i).getNomCollecteur(),
					Datas.getCollecteurs().get(i).getProduit().getNomProduit(),
					Datas.getCollecteurs().get(i).getTypeCollecteur(),
					Datas.getCollecteurs().get(i).getDateCreation().toString(),
					Datas.getCollecteurs().get(i).getReferenceFabricant(),
					Datas.getCollecteurs().get(i).getReferenceFabricant(),
					Datas.getCollecteurs().get(i).getEmplacement().toString()

			});
		}
		
		
		int rowIndex = listeCollecteurs.getRowCount();
		int columnIndex = 0;
		boolean includeSpacing = true;
		 
		Rectangle cellRect = jTableCollecteurs.getCellRect(rowIndex, columnIndex, includeSpacing);
		jTableCollecteurs.scrollRectToVisible(cellRect);
		
		initLargeurColonnes(jTableCollecteurs);
		jTableCollecteurs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}


}
