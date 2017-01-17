package xyz.eyian.roomoccu.controller;

import xyz.eyian.roomoccu.dao.UserViewDao;
import xyz.eyian.roomoccu.view.UserView;

public class UserViewController {
	UserView userView;
	private static UserViewController uvCon;
	private UserViewDao userDao;
	
	/**
	 * Erstellt eine Instanz
	 * @return
	 */
	public static UserViewController getInstance(){
		if (uvCon == null) {
			uvCon = new UserViewController();
		}
		return uvCon;
	}
	
	/**
	 * Konstruktor
	 */
	public UserViewController(){
		userDao = UserViewDao.getInstance();
	}
	
	public void showUserView(){
		userView = new UserView();
		userView.setVisible(true);
	}
	
}
