package xyz.eyian.roomoccu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;



import xyz.eyian.roomoccu.controller.DBAccess;
import xyz.eyian.roomoccu.model.User;

public class UserDao {
	private DBAccess dbaccess;

	/*
	 * Singelton Pattern
	 */
	private static UserDao instance;

	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}

	private UserDao() {
		super();
		dbaccess = DBAccess.getInstance();
	}



}
