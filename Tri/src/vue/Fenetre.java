/**
 * 
 */
package vue;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


/**
 * @author Mehdi HAMDI
 *
 */
public abstract class Fenetre extends JFrame {

	/**
	 * @return the content
	 */
	public JPanel getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(JPanel content) {
		this.content = content;
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
	 * @throws HeadlessException
	 * 
	 */
	private JPanel 		content;
	public Fenetre() throws HeadlessException {
		//super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		setSize(new Dimension(1300,800));
		this.getContentPane().setBackground(Color.CYAN);
		//this.setBackground(Color.BLUE);
		this.setPreferredSize(new Dimension(1100,1000));
		//JPanel contentPane = (JPanel)getContentPane();
		
		// Construction du menu
		JMenuBar menuBar = new MenuAppli(this);
		setJMenuBar(menuBar);		
		
		this.setTitle("Gestion de la déchetterie");
		content 	= (JPanel) this.getContentPane();
		this.setIconImage(UtilVue.scaleImage("logoVert.jpg", 50, 50));
		

		
	}



}
