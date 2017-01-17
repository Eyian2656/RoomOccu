package xyz.eyian.roomoccu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Room> insertCombo(Room room) {
		List<Room> data = null;
		dbaccess.connect();

		String select = "SELECT * FROM rooms";
		try {
			ResultSet resultset = dbaccess.executeQuery(select);
			data = new ArrayList<Room>();
			while (resultset.next()) {
				Room rooms = new Room();
				rooms.setEtage(resultset.getString(2));
				rooms.setRoom(resultset.getString(3));
				data.add(rooms);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbaccess.close();
		}

		return data;
	}

}
