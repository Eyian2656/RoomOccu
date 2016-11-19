package xyz.eyian.roomoccu.controller;


import xyz.eyian.roomoccu.view.LoginView;

public class MainApp {
	
	private static MainApp instance;
	private LoginView view;
	

		public static MainApp getInstance() {
			if (instance == null) {
				instance = new MainApp();
			}
			return instance;
		}

		private MainApp() {
			super();
			view = new LoginView(this);
			view.setVisible(true);
		}
		
		public static void main(String[] args) {
			MainApp.getInstance();
		}
	}

