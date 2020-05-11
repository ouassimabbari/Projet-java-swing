/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matherapie;

/**
 *
 * @author user
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Utilisateur {
    	private static int user_id;
	private static String login;
	private static String password;
	private static String nom;
	private static String prenom;
	private static String sexe;
	private static String date;
	private static float poids;
	private static String adresse;
	private static String telephone;
	private static String email;
	
	
	
	public static void setUser_id(int user_id) {
		Utilisateur.user_id = user_id;
	}

	public static void setLogin(String login) {
		Utilisateur.login = login;
	}

	public static void setPassword(String password) {
		Utilisateur.password = password;
	}

	public static void setNom(String nom) {
		Utilisateur.nom = nom;
	}

	public static void setPrenom(String prenom) {
		Utilisateur.prenom = prenom;
	}

	public static void setSexe(String sexe) {
		Utilisateur.sexe = sexe;
	}

	public static void setDate(String date) {
		Utilisateur.date = date;
	}

	public static void setPoids(float poids) {
		Utilisateur.poids = poids;
	}

	public static void setAdresse(String adresse) {
		Utilisateur.adresse = adresse;
	}

	public static void setTelephone(String telephone) {
		Utilisateur.telephone = telephone;
	}

	public static void setEmail(String email) {
		Utilisateur.email = email;
	}

	public static int getUser_id() {
		return user_id;
	}

	public static String getLogin() {
		return login;
	}

	public static String getPassword() {
		return password;
	}

	public static String getNom() {
		return nom;
	}

	public static String getPrenom() {
		return prenom;
	}

	public static String getSexe() {
		return sexe;
	}

	public static String getDate() {
		return date;
	}

	public static float getPoids() {
		return poids;
	}

	public static String getAdresse() {
		return adresse;
	}

	public static String getTelephone() {
		return telephone;
	}

	public static String getEmail() {
		return email;
	}

	public Utilisateur() {
		setUser_id(0);
		setLogin(null);
		setPassword(null);
		setNom(null);
		setPrenom(null);
		setSexe(null);
		setDate(null);
		setPoids(0);
		setAdresse(null);
		setTelephone(null);
		setEmail(null);
	}
	
	public Utilisateur(String login,
            String password,
            String nom,
            String prenom,
            String sexe,
            String date,
            float poids,
            String adresse,
            String telephone,
            String email) {
	setLogin(login);
	setPassword(password);
	setNom(nom);
	setPrenom(prenom);
	setSexe(sexe);
	setDate(date);
	setPoids(poids);
	setAdresse(adresse);
	setTelephone(telephone);
	setEmail(email);
}

	public Utilisateur(String login, String password) {
		setLogin(login);
		setPassword(password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			String query = "select * from utilisateurs where (login = ?) AND (password = ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, getLogin());
			statement.setString(2, getPassword());

			ResultSet set = statement.executeQuery();
			
			if(set.next()) {
				setUser_id(set.getInt(1));
				setNom(set.getString(4));
				setPrenom(set.getString(5));
				setSexe(set.getString(6));
				setDate(set.getString(7));
				setPoids(set.getFloat(8));
				setAdresse(set.getString(9));
				setTelephone(set.getString(10));
				setEmail(set.getString(11));
			} else {
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	public boolean sInscrire() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			String query = "insert into utilisateurs(Login, password, nom, prenom, sexe, date, poids, adresse, telephone, email) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, getLogin().toLowerCase());
			statement.setString(2, getPassword());
			statement.setString(3, getNom());
			statement.setString(4, getPrenom());
			statement.setString(5, getSexe());
			statement.setString(6, getDate());
			statement.setFloat(7,  getPoids());
			statement.setString(8, getAdresse());
			statement.setString(9, getTelephone());
			statement.setString(10, getEmail());

			statement.execute();

			return true;
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			return false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	public boolean seConnecter() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			String query = "select * from utilisateurs where (login = ?) AND (password = ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, getLogin().toLowerCase());
			statement.setString(2, getPassword());

			ResultSet set = statement.executeQuery();
			
			

			if (set.next()) {
				
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}
	
	public boolean modifier(String login, String password, String nom, String prenom, String sexe, String date,
			float poids, String adresse, String telephone, String email) {
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
				String query = "update utilisateurs set password=?, nom=?, prenom=?, sexe=?, date=?, poids=?, adresse=?, telephone=?, email=? where login=?";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, password);
				statement.setString(2, nom);
				statement.setString(3, prenom);
				statement.setString(4, sexe);
				statement.setString(5, date);
				statement.setFloat(6, poids);
				statement.setString(7, adresse);
				statement.setString(8, telephone);
				statement.setString(9, email);
				statement.setString(10, login);
				return true;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
			
		
		
	}
	

}

