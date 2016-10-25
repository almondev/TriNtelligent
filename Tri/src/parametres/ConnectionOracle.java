 /**
 * 
 */
package parametres;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Afpa
 *
 */
public class ConnectionOracle {

	/**
	 * 
	 */
	private static String urlAfpa = "jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa";
	private static String urlMaison ="jdbc:oracle:thin:testuser/password@localhost:1521:xe";
	
	private static String user[] = {"testuser","stag06"};
	/**
	 * Mot de passe du user
	 */
	private static String password[] = {"password","stag06pw"};
	private static Connection connect;
	
	public static Connection getInstance(String choixSGBDR){
		if(connect == null){
			
			try {
				if(choixSGBDR.equals("maison")){
					connect = DriverManager.getConnection(urlMaison, user[0], password[0]);
				} else {
					connect = DriverManager.getConnection(urlAfpa, user[1], password[1]);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}

}
