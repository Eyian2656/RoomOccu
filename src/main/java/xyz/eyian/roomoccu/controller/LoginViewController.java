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
	 * Objekt oder Variabelen empfangen ?
	 * 
	 * Na die 2 Variabelelelelelelen... wie du es schon dort hin geschrieben hast :D 
	 * Und dann schreibst du hier rein was passieren soll... kannst dir ja auch noch
	 * meine Loginmethode anschauen.
	 */
	public void  login(String user, String pw){
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
