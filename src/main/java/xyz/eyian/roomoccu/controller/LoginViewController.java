package xyz.eyian.roomoccu.controller;

import javax.swing.JOptionPane;

import com.csc.de.VeAuLe.controller.DocumentController;

import xyz.eyian.roomoccu.dao.UserDao;
import xyz.eyian.roomoccu.model.User;
import xyz.eyian.roomoccu.view.LoginView;

public class LoginViewController {
	
	private static LoginViewController instance;
	private LoginView view;
	//TODO: Wozu dient dient diese get instance von Userdao
	UserDao dao = UserDao.getInstance();
	//TODO: Wozu brauche ich das 
	protected String user;
	
	
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
	public login(String user, String pw){
		
		User data = (User) dao.select(user);
		
		if (data == null) {
			JOptionPane.showInternalMessageDialog(null, "Benutzer existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
			return null;
		} else if(data.getPassword().equals(pw)){	
			setUserLogin(data.getUsername());
			JOptionPane.showMessageDialog(null, "LogIn erfolgreich!", "Info", JOptionPane.INFORMATION_MESSAGE);
			view.dispose();
		} else if (!data.getPassword().equals(pw)) {
			JOptionPane.showMessageDialog(null, "Das eingegebene Passwort ist nicht korrekt.", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Verbindung zum Server fehlgeschlagen", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
		return ret;
	
	}

	public String getUserLogin() {
		return user;
	}

	public void setUserLogin(String user) {
		this.user = user;
	}
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
