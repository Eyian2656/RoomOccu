package xyz.eyian.roomoccu.dao;

import xyz.eyian.roomoccu.controller.DBAccess;

public class UserDao {
	private DBAccess dbaccess;

	/*
	 * Singelton Pattern
	 */
	private static UserDao instance;

	/**
	 * liefert eine Instance der ExternalManualDao zurück
	 * TODO: Was ist ExternalmanualDao
	 * @return
	 */

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
