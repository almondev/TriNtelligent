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

import metier.decheterie.Commune;
import parametres.ConnectionOracle;

public class CommuneDao implements GenericDAO<Commune>{
	private static final String SQL_GET_ALL = "SELECT ID_COMMUNE, NOM_COMMUNE FROM COMMUNE ORDER BY NOM_COMMUNE";
	private static final String SQL_FIND_BY_ID =
			"ID_COMMUNE, ABREVIATION, NOM_COMMUNE FROM COMMUNE WHERE ID_COMMUNE = ?";	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement preparedStatement = null;
	PreparedStatement updateTest = null;

	@Override
	public void saveOrUpdate(Commune entite) {
		// TODO Auto-generated method stub

	}
	@Override
	public List<Commune> getAll() {
		List<Commune> lc = new ArrayList<Commune>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = ConnectionOracle.getInstance("maison");
			con = ConnectionOracle.getInstance("afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_GET_ALL);
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.println(rs.getString(2) +  "\t");
				lc.add(new Commune(rs.getInt(1),rs.getString(2)));
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
		return lc;
	}
	@Override
	public Commune get(int id) {
		Commune commune;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
			stmt = con.createStatement();
			preparedStatement = con.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, 1);
            rs = preparedStatement.executeQuery(SQL_FIND_BY_ID);
            int idCommune=0;
            String nomCommune="";
            while (rs.next()) {
            	idCommune = rs.getInt(1);
            	nomCommune = rs.getString(2);
            }
			commune = new Commune(idCommune,nomCommune);
			return commune;
		}catch (ClassNotFoundException e) {
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
		return null;
	}


		@Override
		public void add(Commune entity) {
			// TODO Auto-generated method stub
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
	            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
	            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
				stmt = con.createStatement();
				System.out.println("marche");


				String insertTableSQL = "INSERT INTO COMMUNE"
						+ "(ID_COMMUNE, NOM_COMMUNE) VALUES"
						+ "(?,?)";
				System.out.println("id"+entity.getIdCommune());
				preparedStatement = con.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, entity.getIdCommune());
				preparedStatement.setString(2, entity.getNomCommune());
				// execute insert SQL stetement
				preparedStatement.executeUpdate();

				//con.commit();

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
		public void update(Commune entity) {
			// TODO Auto-generated method stub

		}
		@Override
		public void remove(Commune entity) {
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
				con.commit();
				rs = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM COMMUNE");
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
		/**
		 * 
		 */
		public CommuneDao() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public void removeAll() {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
	            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
	            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
				stmt = con.createStatement();
				
				stmt.executeUpdate("DELETE COMMUNE");


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
		public List<Commune> search(String champ) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Commune getEChamp(String champNomCommune) {
			// TODO A vérifier
			Commune communeTrouve = null;
			try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
	            //con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
	            
	            stmt = con.createStatement();
	            System.out.println("marche");

	            //FINISH Attention espace dans la requête SQL WHERE
	            String searchTableSQL = "SELECT ID_COMMUNE,NOM_COMMUNE FROM COMMUNE"
	            		+ " WHERE NOM_COMMUNE=?";

	            preparedStatement = con.prepareStatement(searchTableSQL);

	            preparedStatement.setString(1, champNomCommune);

	            // execute insert SQL stetement
	            ResultSet rsCommune = preparedStatement.executeQuery();
	            while(rsCommune.next()) {
	                //System.out.print(rs.getInt(1) + "\t");
	                //System.out.println(rs.getString(2) +  "\t");
	                //System.out.println(rs.getString(3));
	            	communeTrouve = new Commune(rsCommune.getInt(1),rsCommune.getString(2));
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
			return communeTrouve;
		}
		@Override
		public int getIndex(String champ) {
			// TODO Auto-generated method stub
			return 0;
		}


	}
