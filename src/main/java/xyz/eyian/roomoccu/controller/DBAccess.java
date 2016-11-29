package xyz.eyian.roomoccu.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



/**
 * Verbinden dieses Java Programm mit der Datenbank
 * @author Ian
 *
 */
public class DBAccess {
	
	private static final String url = "jdbc:mysql://localhost/roomoccu";
	private static final String user = "root";
	private static final String passwort = "";
	private Connection connection;
	private boolean connected;

	
	/**
	 ÜVerbindung mit der Datenbank
	 
	 @return boolean - true wenn verbindung erstellt wurde
	 * TODO: keine ahnung wie die setConnection funktioniert
	 */
	public boolean connect(){
		connected = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			setConnection(DriverManager.getConnection(url, user, passwort));
			connected = true;
		} catch (SQLException e) {
			connected = false;
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connected;
	}
	
	/**
	 * Methode zur Übertragung von Abfragen
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		if (connected) {
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(query);
		} else {
			JOptionPane.showMessageDialog(null, "Verbindung zum Server fehlgeschlagen", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			throw new SQLException("Database not connected");
		}
	}
	/**
	 * Methode welche dazu benötigt wird um jegliche Arten von Änderungen
	 * auszuführen (update, delete, insert)
	 * 
	 * @param query
	 * @return sqlstatement abschicken
	 * @throws SQLException
	 */
	public int executeUpdate(String query) throws SQLException {
		if (connected) {
			Statement stmt = connection.createStatement();
			return stmt.executeUpdate(query);
		} else {
			throw new SQLException("database not Connected");
		}
	}

	/**
	 * Datenbankverbindung wird geschlossen
	 * 
	 * @return connection
	 */
	public boolean close() {
		boolean connected = true;
		try {
			connection.close();
			connected = false;
		} catch (SQLException e) {
			connected = false;
		}
		return connected;
	}

	

	private static DBAccess instance;

	/**
	 * liefert eine Instance des AccessDB zurück
	 * 
	 * @return instance
	 */
	public static DBAccess getInstance() {
		if (instance == null) {
			instance = new DBAccess();
		}
		return instance;
	}

	public boolean isConnected(){return connected;}
	
	public Connection getConnection(){return connection;}
	public void setConnection(Connection connection) {this.connection = connection;}

	
}
