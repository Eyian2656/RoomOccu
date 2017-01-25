package xyz.eyian.roomoccu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import xyz.eyian.roomoccu.controller.DBAccess;
import xyz.eyian.roomoccu.model.Room;

public class UserViewDao {
	private DBAccess dbaccess;

	/*
	 * Singelton Pattern
	 */
	private static UserViewDao instance;

	
	public static UserViewDao getInstance() {
		if (instance == null) {
			instance = new UserViewDao();
		}
		return instance;
	}

	private UserViewDao() {
		super();
		dbaccess = DBAccess.getInstance();
	}

	public ResultSet selectEtage() {
		ResultSet resultset = null;
		dbaccess.connect();

		String select = "SELECT * FROM etage";
		try {
			resultset = dbaccess.executeQuery(select);
	/**		data = new ArrayList<Room>();
			while (resultset.next()) {
				Room rooms = new Room();
				rooms.setEtage(resultset.getString(2));
				data.add(rooms);
				// TODO Test zur ausgabe von etage
				System.out.println(rooms.getEtage());
			}    **/

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbaccess.close();
		}
		return resultset;
	}

	public ResultSet selectRoom() {

		ResultSet resultset = null;
		//List<Room> data = null;
		dbaccess.connect();
		String select = "SELECT Zimmer FROM rooms";
		try {
			resultset = dbaccess.executeQuery(select);
			//TODO
			/**	Zum testen
		 * while(resultset.next()){		
			System.out.println(resultset.getString(1));}
			
			data = new ArrayList<Room>();
			while (resultset.next()) {
				Room rooms = new Room();
				rooms.setRoom(resultset.getString(3));
				data.add(rooms);
				
				// TODO Test zur Ausgabe von Zimmer
				System.out.println(rooms.getRoom()); }*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbaccess.close();
		}
		return resultset;
	}

}
