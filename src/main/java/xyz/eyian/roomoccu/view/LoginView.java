package xyz.eyian.roomoccu.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.csc.de.VeAuLe.controller.LoginController;

import xyz.eyian.roomoccu.controller.LoginViewController;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblUser, lblPWD;
	private JTextField txtUser;
	private JPasswordField pwdPWD;
	private JButton btnLogin, btnCancel;

	public LoginView(LoginViewController controller) {
		super();
		setTitle("Login");

		JPanel pnlUser = new JPanel(new GridLayout());
		JPanel pnlPWD = new JPanel(new GridLayout());
		JPanel pnlUserLogin = new JPanel(new BorderLayout());

		JPanel pnlBTN = new JPanel(new BorderLayout());
		JPanel pnlMain = new JPanel(new BorderLayout());

		lblUser = new JLabel("User:");
		txtUser = new JTextField(12);
		pnlUser.add(lblUser);
		pnlUser.add(txtUser);

		lblPWD = new JLabel("Passwort");
		pwdPWD = new JPasswordField(12);
		pnlPWD.add(lblPWD);
		pnlPWD.add(pwdPWD);

		pnlUserLogin.add(pnlUser, BorderLayout.NORTH);
		pnlUserLogin.add(pnlPWD, BorderLayout.SOUTH);

		btnCancel = new JButton("Login");
		btnCancel.setPreferredSize(new Dimension(170, 30));
		btnLogin = new JButton("Cancel");
		btnLogin.setPreferredSize(new Dimension(170, 30));
		pnlBTN.add(btnLogin, BorderLayout.EAST);
		pnlBTN.add(btnCancel, BorderLayout.WEST);

		pnlMain.add(pnlUserLogin, BorderLayout.NORTH);
		pnlMain.add(pnlBTN, BorderLayout.SOUTH);

		add(pnlMain);
		pnlUser.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		pnlPWD.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		pnlMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setSize(500, 280);
		this.setVisible(false);
	}

	/**
	 *
	 * @author xXxhArdC0re_pr0grAmmerxXx 
	 * Beinhaltet die Methode f�r den Loginvorgang.
	 * 
	 * 
	 * 
	 */
	private class onLogin implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String user = txtUser.getText();
			//.getPassword() hatte nicht funktionert aufgrund dem String,
			// ich hatte das in dem Dateilagerungssystem noch auf depracated.
			// Da der Datentyp char nicht .isEmpty() unterst�tzt, muss man abfragen ob
			// das char ARRAY leer ist.
			char[] pw = pwdPWD.getPassword();

			if (user.isEmpty()) {
				JOptionPane.showMessageDialog(null, "User fehlt", "", JOptionPane.ERROR_MESSAGE);
			} else if (pw.length == 0) {
				JOptionPane.showMessageDialog(null, "Kennwort fehlt", "", JOptionPane.ERROR_MESSAGE);
			} else {
				LoginViewController.getInstance().login(user);
			}
		}
	}
}
