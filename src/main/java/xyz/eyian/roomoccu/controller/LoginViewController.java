package xyz.eyian.roomoccu.controller;

import javax.swing.JOptionPane;
import xyz.eyian.roomoccu.dao.UserDao;
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
	public User onLogin(String user, char[] pw){
		System.out.println("woop");
		User data = UserDao.getInstance().select(user);
		
		if (data == null) {
			JOptionPane.showInternalMessageDialog(null, "Benutzer existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
			System.out.println("null");
			return null;
		} else if(data.getPassword().equals(pw.toString())){	
			JOptionPane.showMessageDialog(null, "LogIn erfolgreich!", "Info", JOptionPane.INFORMATION_MESSAGE);
			view.dispose();
			System.out.println(" Erfolgreich eingelocht");
		} else if (!data.getPassword().equals(pw)) {
			JOptionPane.showMessageDialog(null, "Das eingegebene Passwort ist nicht korrekt.", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			System.out.println(data.getPassword());
			System.out.println(pw);
			System.out.println("1");
		} else {
			JOptionPane.showMessageDialog(null, "Verbindung zum Server fehlgeschlagen", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("2");
		}
		return data;	
	}
}
