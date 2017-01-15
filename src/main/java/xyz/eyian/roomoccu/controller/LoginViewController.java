package xyz.eyian.roomoccu.controller;


import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import xyz.eyian.roomoccu.dao.UserDao;
import xyz.eyian.roomoccu.model.User;
import xyz.eyian.roomoccu.view.LoginView;
import xyz.eyian.roomoccu.view.UserView;

public class LoginViewController {
	
	private static LoginViewController instance;
	private UserView view;

	
	
	public static LoginViewController getInstance(){
		if (instance == null) {
			instance = new LoginViewController();
		}
		return instance;
	}
	
	LoginViewController(){
		super();
		view = new UserView(this);
		view.setVisible(true);
	}
	public User onLogin(String user, char[] pw){
		System.out.println("woop");
		User data = UserDao.getInstance().select(user);
		
		if (data == null) {
			JOptionPane.showInternalMessageDialog(null, "Benutzer existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
			System.out.println("null");
			return null;
		} 
		if(StringUtils.equals(data.getPassword(), String.valueOf(pw))){	
			JOptionPane.showMessageDialog(null, "LogIn erfolgreich!", "Info", JOptionPane.INFORMATION_MESSAGE);
			view.dispose();
			// TODO: Hier kommt die neue VIEW
			System.out.println(" Erfolgreich eingelocht");
		} else {
			JOptionPane.showMessageDialog(null, "Das eingegebene Passwort ist nicht korrekt.", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
		return data;	
	}
}
