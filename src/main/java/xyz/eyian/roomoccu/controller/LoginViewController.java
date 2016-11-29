package xyz.eyian.roomoccu.controller;

import xyz.eyian.roomoccu.model.User;
import xyz.eyian.roomoccu.view.LoginView;

public class LoginViewController {
	
	private static LoginViewController instance;
	private LoginView view;
	
	
	public static LoginViewController getInstance(){
		if (instance == null) {
			instance = new LoginViewController();
		}
		return instance;
	}
	
	LoginViewController(){
		super();
		view = new LoginView(this);
		view.setVisible(true);
	}
	/*
	 *TODO: Wieso nehmen wir kein ganzes Objekt ? Und müsste pw nicht char[]
	 */
	public void  login(String user, String pw){
		
		User ret = (User) dao.select(username);
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
