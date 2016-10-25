/**
 * 
 */
package vue;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.Datas;


/**
 * @author Afpa
 *
 */
public class FenetreListLieux extends Fenetre {
	JPanel content;
	private JTable 				jTableListeLieux;
	private DefaultTableModel 	modelTableLieux;
	JScrollPane zoneTable;
	/**
	 * @throws HeadlessException
	 */
	public FenetreListLieux() throws HeadlessException {
		// TODO Auto-generated constructor stub
		content = (JPanel)getContentPane();
		JPanel panel = new JPanel();
		content.add(panel, BorderLayout.CENTER);
		String [] cols = {"numéro", "Voie","Adresse", "Complement adresse", "Commune", "Longitude","Latitude"};
		modelTableLieux = new DefaultTableModel(cols, 0);
		jTableListeLieux = new JTable(modelTableLieux);
		JScrollPane zoneTable;
		zoneTable = new JScrollPane(jTableListeLieux,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		zoneTable.setViewportBorder(new LineBorder(null, 2, true));
		zoneTable.setAutoscrolls(true); // default false
		refreshJtableLieux();
		panel.add(zoneTable);
		
		
	}
	private void refreshJtableLieux() {
		// TODO Auto-generated method stub
		for (int i=0; i < Datas.getLieux().size() ; i++){
			this.getModelTableLieux().addRow(new Object[] {
					Datas.getLieux().get(i).getNumero(),
					Datas.getLieux().get(i).getVoie(),
					Datas.getLieux().get(i).getAdresse(),
					Datas.getLieux().get(i).getComplementAdresse(),
					Datas.getLieux().get(i).getCommune(),
					Datas.getLieux().get(i).getLongitude(),
					Datas.getLieux().get(i).getLattitude()
			});
		}
	}
	/**
	 * @return the contentPane
	 */
	public JPanel getContent() {
		return content;
	}
	/**
	 * @param contentPane the contentPane to set
	 */
	public void setContent(JPanel content) {
		this.content = content;
	}
	/**
	 * @return the jTableListeLieux
	 */
	public JTable getjTableListeLieux() {
		return jTableListeLieux;
	}
	/**
	 * @param jTableListeLieux the jTableListeLieux to set
	 */
	public void setjTableListeLieux(JTable jTableListeLieux) {
		this.jTableListeLieux = jTableListeLieux;
	}
	/**
	 * @return the modelTableLieux
	 */
	public DefaultTableModel getModelTableLieux() {
		return modelTableLieux;
	}
	/**
	 * @param modelTableLieux the modelTableLieux to set
	 */
	public void setModelTableLieux(DefaultTableModel modelTableLieux) {
		this.modelTableLieux = modelTableLieux;
	}
	/**
	 * @return the zoneTable
	 */
	public JScrollPane getZoneTable() {
		return zoneTable;
	}
	/**
	 * @param zoneTable the zoneTable to set
	 */
	public void setZoneTable(JScrollPane zoneTable) {
		this.zoneTable = zoneTable;
	}

}
