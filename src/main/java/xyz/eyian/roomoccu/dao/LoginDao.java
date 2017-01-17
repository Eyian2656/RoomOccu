package xyz.eyian.roomoccu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import xyz.eyian.roomoccu.controller.DBAccess;
import xyz.eyian.roomoccu.model.User;

/**
 * Diese Daot dient als Login Verbindung zur Datenbank.
 * @author Ian
 *
 */
public class LoginDao {

	private DBAccess dbaccess;

	/*
	 * Singelton Pattern
	 */
	private static LoginDao instance;

	public static LoginDao getInstance() {
		if (instance == null) {
			instance = new LoginDao();
		}
		return instance;
	}

	private LoginDao() {
		super();
		dbaccess = DBAccess.getInstance();
	}
	/*
	 * CRUD Methods
	 */
	/**
	 * SQL Statement, welches dafür zuständig ist in die UserTabelle Daten
	 * einzufügen
	 * TODO: Verstehe nicht warum es 2 Select gibt und auch den try block nicht
	 * @param listEntry
	 * @return ResultSet's
	 */
	
	public User select(User u) {
		return select(u.getUsername());
	}

	/**
	 * SQL Statement, welches dafür zuständig ist aus der UserTabelle einen
	 * bestimmten User anzuzeigen.
	 * 
	 * @return ResultSet's
	 */
	public User select(String username) {
		User result = null;
		dbaccess.connect();

		String select = "SELECT * FROM Nutzer WHERE Nutzername = '" + username + "'";

		try {
			ResultSet resultset = dbaccess.executeQuery(select);
			while (resultset.next()) {
				result = new User(resultset.getInt(1), resultset.getString(2), resultset.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbaccess.close();
		}
		return result;
	}
	
}


