/**
 * 
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.KeyEvent;

import control.AppActionListener;
import net.miginfocom.swing.MigLayout;


/**
 * @author Mehdi HAMDI
 *
 */
public class FenetreAccueil extends Fenetre {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel 		lblLogin;
	private JLabel		lblPassword;
	private JTextField 	txtLogin;
	private JTextField	txtPassword;
	private JButton		cmdConnexion;
	private JButton 	cmdPasser;
	private ButtonGroup groupChoixSGBDR;
    JRadioButton 		optHome;
    JRadioButton 		optAfpa;

	/**
	 * @throws HeadlessException
	 */
	public FenetreAccueil() throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		setSize(new Dimension(100,200));
		this.setPreferredSize(new Dimension(400,200));
		JPanel contentPane = (JPanel)getContentPane();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//		contentPane.setBackground(ConstantesEcran.COULEUR_FOND);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][grow][grow]"));
		
		
		// Construction du formulaire de connextion avec Login et password
		lblLogin 			= new JLabel("Identifiant");
		lblPassword 		= new JLabel("Mot de passe");
		txtLogin			= new JTextField();
		txtPassword			= new JTextField();
		
		cmdConnexion		= new JButton("Connexion");
		cmdPasser			= new JButton("Continuer");
		
		groupChoixSGBDR 	= 	new ButtonGroup();
		optHome = new JRadioButton("Base de donnée Home", true);
		optHome.setMnemonic(KeyEvent.VK_1);
		optHome.setActionCommand("homeBDD");
		optAfpa = new JRadioButton("Base de donnée AFPA");
		optAfpa.setMnemonic(KeyEvent.VK_2);
		optAfpa.setActionCommand("AFPABDD");
		groupChoixSGBDR.add(optHome);
		groupChoixSGBDR.add(optAfpa);
		cmdConnexion.addActionListener(new AppActionListener(this));
		cmdPasser.addActionListener(new AppActionListener(this));

		contentPane.add(lblLogin, 		"cell 0 0,alignx trailing");
		contentPane.add(txtLogin, 		"cell 1 0,growx");
		contentPane.add(lblPassword, 	"cell 0 1,alignx trailing,aligny top");
		contentPane.add(txtPassword, 	"cell 1 1,growx,aligny top");
		contentPane.add(cmdConnexion, 	"cell 0 2,alignx trailing");
		contentPane.add(cmdPasser, 		"cell 1 2,growx,aligny top");
		contentPane.add(optHome, 		"cell 0 3,alignx trailing");
		contentPane.add(optAfpa, 		"cell 1 3,growx");
		
		
		
		
		
	}
	/**
	 * @return the lblLogin
	 */
	public JLabel getLblLogin() {
		return lblLogin;
	}
	/**
	 * @param lblLogin the lblLogin to set
	 */
	public void setLblLogin(JLabel lblLogin) {
		this.lblLogin = lblLogin;
	}
	/**
	 * @return the lblPassword
	 */
	public JLabel getLblPassword() {
		return lblPassword;
	}
	/**
	 * @param lblPassword the lblPassword to set
	 */
	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}
	/**
	 * @return the txtLogin
	 */
	public JTextField getTxtLogin() {
		return txtLogin;
	}
	/**
	 * @param txtLogin the txtLogin to set
	 */
	public void setTxtLogin(JTextField txtLogin) {
		this.txtLogin = txtLogin;
	}
	/**
	 * @return the txtPassword
	 */
	public JTextField getTxtPassword() {
		return txtPassword;
	}
	/**
	 * @param txtPassword the txtPassword to set
	 */
	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}
	/**
	 * @return the cmdConnexion
	 */
	public JButton getCmdConnexion() {
		return cmdConnexion;
	}
	/**
	 * @param cmdConnexion the cmdConnexion to set
	 */
	public void setCmdConnexion(JButton cmdConnexion) {
		this.cmdConnexion = cmdConnexion;
	}
	/**
	 * @return the groupChoixSGBDR
	 */
	public ButtonGroup getGroupChoixSGBDR() {
		return groupChoixSGBDR;
	}
	/**
	 * @param groupChoixSGBDR the groupChoixSGBDR to set
	 */
	public void setGroupChoixSGBDR(ButtonGroup groupChoixSGBDR) {
		this.groupChoixSGBDR = groupChoixSGBDR;
	}
	/**
	 * @return the optHome
	 */
	public JRadioButton getOptHome() {
		return optHome;
	}
	/**
	 * @param optHome the optHome to set
	 */
	public void setOptHome(JRadioButton optHome) {
		this.optHome = optHome;
	}
	/**
	 * @return the optAfpa
	 */
	public JRadioButton getOptAfpa() {
		return optAfpa;
	}
	/**
	 * @param optAfpa the optAfpa to set
	 */
	public void setOptAfpa(JRadioButton optAfpa) {
		this.optAfpa = optAfpa;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the cmdPasser
	 */
	public JButton getCmdPasser() {
		
		return cmdPasser;
	}
	/**
	 * @param cmdPasser the cmdPasser to set
	 */
	public void setCmdPasser(JButton cmdPasser) {
		this.cmdPasser = cmdPasser;
	}
	
	
	
	
}
