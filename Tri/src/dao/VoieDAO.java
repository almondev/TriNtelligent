package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.decheterie.Voie;

public class VoieDAO implements GenericDAO<Voie> {
	
	// Constants ----------------------------------------------------------------------------------
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement preparedStatement = null;
    PreparedStatement updateTest = null;
    private static final String SQL_GET_ALL = "SELECT ID_VOIE, ABREVIATION, NOM_VOIE FROM VOIE ORDER BY ID_VOIE";
	
	
	private static final String SQL_FIND_BY_ID =
        "SELECT id, email, firstname, lastname, birthdate FROM User WHERE id = ?";
    private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD =
        "SELECT id, email, firstname, lastname, birthdate FROM User WHERE email = ? AND password = MD5(?)";
    private static final String SQL_LIST_ORDER_BY_ID =
        "SELECT id, email, firstname, lastname, birthdate FROM User ORDER BY id";
    private static final String SQL_INSERT =
        "INSERT INTO VOIE (ID, ABREVIATION, NOM_VOIE) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE =
        "UPDATE User SET email = ?, firstname = ?, lastname = ?, birthdate = ? WHERE id = ?";
    private static final String SQL_DELETE =
        "DELETE FROM User WHERE id = ?";
    private static final String SQL_EXIST_EMAIL =
        "SELECT id FROM User WHERE email = ?";
    private static final String SQL_CHANGE_PASSWORD =
        "UPDATE User SET password = MD5(?) WHERE id = ?";
    private static final String SQL_TAILLE =
            "SELECT COUNT(*) AS count FROM VOIE";

	public VoieDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("VoieDAO");
	}

	@Override
	public void saveOrUpdate(Voie entite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Voie> getAll() {
		// TODO Auto-generated method stub
		List<Voie> lv = new ArrayList<Voie>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            while(rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.println(rs.getString(2) +  "\t");
                System.out.println(rs.getString(3));
                lv.add(new Voie(rs.getInt(1),rs.getString(2),rs.getString("NOM_VOIE")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return lv;
	}

	@Override
	public Voie get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Voie entity) {
		// TODO Auto-generated method stub
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
            
            stmt = con.createStatement();
            System.out.println("marche");

            
            String insertTableSQL = "INSERT INTO VOIE"
            		+ "(ID_VOIE, ABREVIATION, NOM_VOIE) VALUES"
            		+ "(?,?,?)";
            System.out.println("id"+entity.getId());
            preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getAbreviation());
            preparedStatement.setString(3, entity.getNomVoie());
            // execute insert SQL stetement
            preparedStatement .executeUpdate();
            
            //con.commit();
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		
	}

	@Override
	public void update(Voie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Voie entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int taille() {
		int taille = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
			//stmt = con.createStatement();
			//rs = DatabaseService.statementDataBase().executeQuery(SQL_TAILLE);
			stmt = con.createStatement();
			//con.commit();
			rs = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM VOIE");
			rs.next();
			int count = rs.getInt("rowcount");
			rs = stmt.executeQuery("select * from voie");
			
			System.out.println("taille dao"+count);
//			while(rs.next()){
//				taille=rs.getInt(1);
//			}
		        

			return count;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
			stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE VOIE");


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
	public List<Voie> search(String champ) {
		// TODO Auto-generated method stub
		List<Voie> lv = new ArrayList<Voie>();
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
            
            stmt = con.createStatement();
            System.out.println("marche");

            
            String searchTableSQL = "SELECT ID, ABREVIATION, NOM_VOIE FROM VOIE"
            		+ "WHERE ABREVIATION=? OR NOM_VOIE=?";

            preparedStatement = con.prepareStatement(searchTableSQL);

            preparedStatement.setString(1, champ);
            preparedStatement.setString(2, champ);
            // execute insert SQL stetement
            rs = preparedStatement.executeQuery();
            while(rs.next()) {
                //System.out.print(rs.getInt(1) + "\t");
                //System.out.println(rs.getString(2) +  "\t");
                //System.out.println(rs.getString(3));
                lv.add(new Voie(rs.getInt(1),rs.getString(2),rs.getString("NOM_VOIE")));
            }
            
            //con.commit(); pas nécessaire autocommit
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return lv;
	}
	// getEchamp récupère la voie type générique E avec le champ nom voie comme paramètre
	@Override
	public Voie getEChamp(String champNomVoie) {
		// TODO A vérifier
		Voie voieTrouve = null;
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
            
            stmt = con.createStatement();
            System.out.println("nom de la voie :"+champNomVoie);

            
            String searchTableSQL = "SELECT ID_VOIE, ABREVIATION, NOM_VOIE FROM VOIE WHERE NOM_VOIE=?";

            preparedStatement = con.prepareStatement(searchTableSQL);

            preparedStatement.setString(1, champNomVoie);
            System.out.println("preparedStatement champNomVoie : "+preparedStatement);
            // execute insert SQL stetement
            ResultSet rsVoie = preparedStatement.executeQuery();
            while(rsVoie.next()) {
                //System.out.print(rs.getInt(1) + "\t");
                //System.out.println(rs.getString(2) +  "\t");
                //System.out.println(rs.getString(3));
                voieTrouve = new Voie(rsVoie.getInt(1),rsVoie.getString(2),rsVoie.getString("NOM_VOIE"));
            }
            rsVoie.close();
            
            //con.commit(); pas nécessaire autocommit
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return voieTrouve;
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
