package xyz.eyian.roomoccu.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import xyz.eyian.roomoccu.controller.MainApp;

public class LoginView extends JFrame{
	
	private JLabel lblUser, lblPWD;
	private JTextField txtUser;
	private JPasswordField pwdPWD;
	private JButton btnLogin, btnCancel;
	
	
	public LoginView(MainApp mainApp){
		super();
		setTitle("Login");
		
		JPanel pnlUser = new JPanel(new GridLayout());
		JPanel pnlPWD = new JPanel(new GridLayout());
		JPanel pnlUserLogin = new JPanel(new BorderLayout());
		
		JPanel pnlBTN = new JPanel(new GridLayout());
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
		
		btnCancel = new JButton("Cancel");
		btnLogin = new JButton("Login");
		pnlBTN.add(btnLogin);
		pnlBTN.add(btnCancel);
		
		pnlMain.add(pnlUserLogin, BorderLayout.NORTH);
		pnlMain.add(pnlBTN, BorderLayout.SOUTH);
		
		add(pnlMain);
		pnlUser.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		pnlPWD.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		pnlMain.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		this.setVisible(false);

		
	}
	
	public class onLogin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			MainApp.getInstance().sum(txtField, txtField2);
		}
	}

	int sum (JTextField field, String b)
	
	
	
}
