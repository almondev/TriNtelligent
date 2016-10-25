/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import metier.decheterie.Fabricant;
/**
 * @author Afpa
 *
 */
public class FabricantDao implements GenericDAO<Fabricant> {
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement preparedStatement = null;
	PreparedStatement updateTest = null;
	/**
	 * 
	 */
	public FabricantDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveOrUpdate(Fabricant entite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fabricant> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fabricant get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Fabricant entity) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
			stmt = con.createStatement();
			System.out.println("marcheFabricant");


			String insertTableSQL = "INSERT INTO FABRICANT"
					+ "(ID_FABRICANT, NOM_FABRICANT) VALUES"
					+ "(?,?)";

			preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, entity.getIdFabricant());
			preparedStatement.setString(2, entity.getNomFabricant());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//rs.close();
				stmt.close();
				con.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void update(Fabricant entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Fabricant entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAll() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
			stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FABRICANT");


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Fabricant> search(String champ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int taille() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fabricant getEChamp(String champ) {
		// TODO Auto-generated method stub
		return null;
	}
	//Fermeture de la connection :
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getIndex(String champ) {
		// TODO Auto-generated method stub
		return 0;
	}
}
