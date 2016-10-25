package metier.user;

public class Utilisateur {
	private int 	idUtilisateur;
	private String 	nomUtilisateur;
	private String	login;
	private String	password;

	public Utilisateur() {
		// TODO Auto-generated constructor stub
		
	}
	
	




	/**
	 * @param idUtilisateur
	 * @param nomUtilisateur
	 * @param login
	 * @param password
	 */
	public Utilisateur(int idUtilisateur, String nomUtilisateur, String login, String password) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.login = login;
		this.password = password;
	}






	/**
	 * @return the idUtilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}






	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}






	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}






	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}






	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
