package xyz.eyian.roomoccu.controller;

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
	
	private LoginViewController(){
		super();
		view = new LoginView(this);
		view.setVisible(true);
	}
	
	public void  login(User user){
		
	}
}
