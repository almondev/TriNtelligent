/**
 * 
 */
package vue.jpanel;

import java.awt.Color;

import javax.swing.JPanel;

import vue.Fenetre;

/**
 * @author Mehdi HAMDI
 *
 */
public class PanelAppli extends JPanel {
	private Fenetre fenetre;

	/**
	 * @param fenetre
	 */
	public PanelAppli(Fenetre fenetre) {
		super();
		this.fenetre = fenetre;
		this.setBackground(Color.CYAN);
	}

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
	

}
