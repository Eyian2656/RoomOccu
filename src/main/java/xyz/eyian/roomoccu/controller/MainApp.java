package xyz.eyian.roomoccu.controller;

import xyz.eyian.roomoccu.dao.UserViewDao;

public class MainApp {
	
		public static void main(String[] args) {
			UserViewDao.getInstance().selectEtage();
			LoginViewController.getInstance();
			UserViewDao.getInstance().selectRoom();
		}
	}

