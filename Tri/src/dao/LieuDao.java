package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.decheterie.Commune;
import metier.decheterie.EmplacementDechetterie;
import metier.decheterie.EmplacementDistributeur;
import metier.decheterie.EmplacementExterne;
import metier.decheterie.Lieu;
import metier.decheterie.Voie;

public class LieuDao implements GenericDAO<Lieu> {
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement preparedStatement = null;
	PreparedStatement updateTest = null;

	Lieu lieu;
	Voie voie;
	Commune commune;
	EmplacementDechetterie 	emplacementDechetterie;
	EmplacementDistributeur emplacementDistributeur;
	EmplacementExterne 		emplacementExterne;
	@Override
	public void saveOrUpdate(Lieu entite) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Lieu> getAll() {
		// TODO Auto-generated method stub
		int 	idLieu				=0;
		int 	numero				=0;
		int 	idVoie				=0;
		int 	idCommune			=0;
		String 	adresse 			="";
		String 	complementAdresse	="";
		float  	lattitude			=0.0F;
		float	longitude			=0.0F;
		String 	typeEmplacement 	="";
		List<Lieu> listLieu;
		System.out.println("***********************************************");
		listLieu = new ArrayList<Lieu>();
		String 	SelectLieu 				= "SELECT ID_LIEU, NUMERO,ID_VOIE, ADRESSE, COMPLEMENT_ADRESSE, ID_COMMUNE, LATTITUDE, LONGITUDE,TYPE_EMPLACEMENT FROM LIEU";
		String 	selectVoieID			= "SELECT ID_VOIE,ABREVIATION,NOM_VOIE FROM VOIE WHERE ID_VOIE = ?";
		String 	selectCommuneID			= "SELECT ID_COMMUNE,NOM_COMMUNE FROM COMMUNE WHERE ID_COMMUNE = ?";
		String 	SelectDechetterie 		= "SELECT ID_DECHETTERIE, ID_LIEU,NOM_DECHETTERIE,OUVERT_WEEK_END FROM LIEU_DECHETTERIE WHERE ID_LIEU =?";
		String 	SelectDistributeur 		= "SELECT ID_DISTRIBUTEUR,ID_LIEU,NOM_DISTRIBUTEUR FROM LIEU_DISTRIBUTEUR WHERE ID_LIEU =?";
		String 	SelectExterne 			= "SELECT ID_EXTERNE, ID_LIEU, NOMBRE_MAX_COLLECTEURS FROM LIEU_EXTERNE WHERE ID_LIEU =?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
			//con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
			stmt = con.createStatement();
			rs = stmt.executeQuery(SelectLieu);
			int j=0;
			while(rs.next()) {
				System.out.println("j ="+j);
				idLieu  			= rs.getInt(1);
				numero  			= rs.getInt(2);
				idVoie  			= rs.getInt(3);
				adresse 			= rs.getString(4);
				complementAdresse	= rs.getString(5);
				idCommune  			= rs.getInt(6);
				lattitude			= rs.getFloat(7);
				longitude			= rs.getFloat(8);
				typeEmplacement		= rs.getString(9);
				preparedStatement = con.prepareStatement(selectVoieID);
				preparedStatement.setInt(1, idVoie);
				ResultSet rs2 = preparedStatement.executeQuery();
				while(rs2.next()) {
					voie= new Voie(rs2.getInt(1), rs2.getString(2), rs2.getString(3));
				}
				preparedStatement = con.prepareStatement(selectCommuneID);
				preparedStatement.setInt(1, idCommune);           
				ResultSet rs3 = preparedStatement.executeQuery();
				while(rs3.next()) {
					commune = new Commune(rs3.getInt(1), rs3.getString(2));
				}            


				if 	(typeEmplacement.equals("DECHETTERIE")){
					preparedStatement = con.prepareStatement(SelectDechetterie);
					preparedStatement.setInt(1, idLieu);
					ResultSet rs4 = preparedStatement.executeQuery();
					while(rs4.next()) {
						if (rs4.getInt(4)==1){
							emplacementDechetterie = new EmplacementDechetterie(idLieu, numero, voie, adresse, complementAdresse, commune, lattitude, longitude, rs4.getString(3),true);
						} else {
							emplacementDechetterie = new EmplacementDechetterie(idLieu, numero, voie, adresse, complementAdresse, commune, lattitude, longitude, rs4.getString(3), false);
						}
					}
					rs4.close();
					listLieu.add(emplacementDechetterie);
					System.out.println("déchetterie1");

				} else if 	(typeEmplacement.equals("DISTRIBUTEUR")){
					preparedStatement = con.prepareStatement(SelectDistributeur);
					preparedStatement.setInt(1, idLieu);
					ResultSet rs5 = preparedStatement.executeQuery();
					while(rs5.next()) {
						emplacementDistributeur = new EmplacementDistributeur(idLieu, numero, voie, adresse, complementAdresse, commune, lattitude, longitude, rs5.getString(1));
					}
					rs5.close();
					listLieu.add(emplacementDistributeur);
					System.out.println("distributeur");
				} else {
					preparedStatement = con.prepareStatement(SelectExterne);
					preparedStatement.setInt(1, idLieu);
					ResultSet rs6 = preparedStatement.executeQuery();
					while(rs6.next()) {
						emplacementExterne 		= new EmplacementExterne(idLieu, numero, voie, adresse, complementAdresse, commune, lattitude, longitude,rs6.getInt(1));  
					}
					rs6.close();
					listLieu.add(emplacementExterne);
					System.out.println("externe");

				}
				j++;
			}
			System.out.println("********************Fin getAll Lieu***************************");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
				stmt.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listLieu;
	}

	@Override
	public Lieu get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Lieu entity) {
		// TODO Auto-generated method stub
		// TODO vérifier les doublons.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
			//con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
			int tailleLieu=0;
			stmt = con.createStatement();
			String insertLieu 			= "INSERT INTO LIEU (ID_LIEU, NUMERO,ID_VOIE, ADRESSE, COMPLEMENT_ADRESSE, ID_COMMUNE, LATTITUDE, LONGITUDE,TYPE_EMPLACEMENT) values (?,?,?,?,?,?,?,?,?)";
			String insertDechetterie 	= "INSERT INTO LIEU_DECHETTERIE (ID_DECHETTERIE, ID_LIEU,NOM_DECHETTERIE,OUVERT_WEEK_END) VALUES (?,?,?,?)";
			String insertDistributeur 	= "INSERT INTO LIEU_DISTRIBUTEUR (ID_DISTRIBUTEUR,ID_LIEU,NOM_DISTRIBUTEUR) VALUES (?,?,?);";
			String insertExterne 		= "INSERT INTO LIEU_EXTERNE (ID_EXTERNE, ID_LIEU, NOMBRE_MAX_COLLECTEURS) VALUES (?,?,?);";
			EmplacementDechetterie 	new_lieu_dechetterie;
			EmplacementDistributeur new_lieu_distributeur;
			EmplacementExterne		new_lieu_externe;

			if (entity instanceof EmplacementDechetterie) {
				new_lieu_dechetterie = (EmplacementDechetterie) entity;
				//Insertion dans la table Lieu:
				System.out.println("Numéro de voie à insérer " + new_lieu_dechetterie.getVoie().getId());
				System.out.println("lattitude : " + new_lieu_dechetterie.getLattitude());
				tailleLieu =taille();
				preparedStatement = con.prepareStatement(insertLieu);
				preparedStatement.setInt	(1, (tailleLieu+1));
				preparedStatement.setInt	(2, new_lieu_dechetterie.getNumero());
				preparedStatement.setInt	(3, new_lieu_dechetterie.getVoie().getId());
				preparedStatement.setString	(4, new_lieu_dechetterie.getAdresse());			
				preparedStatement.setString	(5, new_lieu_dechetterie.getComplementAdresse());	
				preparedStatement.setFloat	(6, new_lieu_dechetterie.getCommune().getIdCommune());
				preparedStatement.setFloat	(7, new_lieu_dechetterie.getLattitude());
				preparedStatement.setFloat	(8, new_lieu_dechetterie.getLongitude());
				preparedStatement.setString	(9, "DECHETTERIE");


				preparedStatement .executeUpdate();
				ResultSet rsDech = stmt.executeQuery("SELECT MAX(ID_DECHETTERIE) FROM LIEU_DECHETTERIE");
				rsDech.next();
				int count_dechetterie = rsDech.getInt(1);

				//Insertion dans la table déchetterie:
				preparedStatement = con.prepareStatement(insertDechetterie);
				preparedStatement.setInt(1, count_dechetterie+1);
				preparedStatement.setInt(2,(tailleLieu+1));
				preparedStatement.setString(3, new_lieu_dechetterie.getNomDechetterie());
				if(new_lieu_dechetterie.getOuvertWeekEnd()){
					preparedStatement.setInt(4,1);
				} else {
					preparedStatement.setInt(4,0);					
				}
				preparedStatement .executeUpdate();

			}
			if (entity instanceof EmplacementDistributeur) {
				new_lieu_distributeur = (EmplacementDistributeur) entity;
				tailleLieu =taille();
				//Insertion dans la table Lieu:
				preparedStatement = con.prepareStatement(insertLieu);
				preparedStatement.setInt	(1, (tailleLieu+1));
				preparedStatement.setInt	(2, new_lieu_distributeur.getNumero());
				preparedStatement.setInt	(3, new_lieu_distributeur.getVoie().getId());
				preparedStatement.setString	(4, new_lieu_distributeur.getAdresse());			
				preparedStatement.setString	(5, new_lieu_distributeur.getComplementAdresse());	
				preparedStatement.setFloat	(6, new_lieu_distributeur.getCommune().getIdCommune());
				preparedStatement.setFloat	(7, new_lieu_distributeur.getLattitude());
				preparedStatement.setFloat	(8, new_lieu_distributeur.getLongitude());
				preparedStatement.setString	(9, "DISTRIBUTEUR");


				preparedStatement .executeUpdate();
				//Insertion dans la table distributeur:
				rs = stmt.executeQuery("SELECT MAX(ID_DISTRIBUTEUR) FROM LIEU_DISTRIBUTEUR");
				rs.next();
				int count_distributeur = rs.getInt(1);
				preparedStatement = con.prepareStatement(insertDistributeur);
				preparedStatement.setInt(1, (count_distributeur+1));
				preparedStatement.setInt(2,(tailleLieu+1));
				preparedStatement.setString(3, new_lieu_distributeur.getNomDistributeur());

			}
			if (entity instanceof EmplacementExterne) {
				new_lieu_externe = (EmplacementExterne) entity;
				tailleLieu =taille();
				preparedStatement = con.prepareStatement(insertLieu);
				preparedStatement.setInt	(1, (tailleLieu+1));
				preparedStatement.setInt	(2, new_lieu_externe.getNumero());
				preparedStatement.setInt	(3, new_lieu_externe.getVoie().getId());
				preparedStatement.setString	(4, new_lieu_externe.getAdresse());			
				preparedStatement.setString	(5, new_lieu_externe.getComplementAdresse());	
				preparedStatement.setFloat	(6, new_lieu_externe.getCommune().getIdCommune());
				preparedStatement.setFloat	(7, new_lieu_externe.getLattitude());
				preparedStatement.setFloat	(8, new_lieu_externe.getLongitude());
				preparedStatement.setString	(9, "EXTERNE");


				preparedStatement .executeUpdate();
				//Insertion dans la table emplacement externe:
				rs = stmt.executeQuery("SELECT MAX(ID_EXTERNE) FROM LIEU_EXTERNE");
				rs.next();
				int count_externe = rs.getInt(1);
				preparedStatement = con.prepareStatement(insertDistributeur);
				preparedStatement.setInt(1, (count_externe+1));
				preparedStatement.setInt(2,(tailleLieu+1));
				preparedStatement.setInt(3, new_lieu_externe.getNombreMaxCollecteurs());

				preparedStatement = con.prepareStatement(insertDistributeur);

				preparedStatement .executeUpdate();
			}
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
	public void update(Lieu entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Lieu entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Lieu> search(String champ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int taille() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:stag06/stag06pw@junon:1521:afpa");
			//con = DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost:1521:xe");
			//stmt = con.createStatement();
			//rs = DatabaseService.statementDataBase().executeQuery(SQL_TAILLE);
			stmt = con.createStatement();
			//con.commit();
			//rs = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM LIEU");
			rs = stmt.executeQuery("SELECT MAX(ID_LIEU) FROM LIEU");
			rs.next();
			int count = rs.getInt(1);
			//rs = stmt.executeQuery("select * from voie");

			System.out.println("taille dao Lieu"+count);
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
	// Taille courante du nombre d'emplacement de type déchetterie
	public int tailleDechetterie(){
		return 0;
	}
	// Taille courante du nombre d'emplacement de type distributeur
	public int tailleDistributeur(){
		return 0;
	}

	// Taille courante du nombre d'emplacement de type distributeur
	public int tailleExterne(){
		return 0;
	}
	@Override
	public Lieu getEChamp(String champ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex(String champ) {
		// TODO Auto-generated method stub
		return 0;
	}





}
