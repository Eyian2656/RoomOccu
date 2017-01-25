package xyz.eyian.roomoccu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import xyz.eyian.roomoccu.controller.UserViewController;


public class UserView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Hier ist das Hauptmen�
	 */

	private JLabel lblEtage, lblRoom, lblVon, lblBis;
	private JComboBox<String> cbEtage, cbRoom, cbVonH, cbVonM, cbBisH, cbBisM;
	private JTable tUbersicht;
	//private String[] etage ;
	private String[] room = {"Von", "Bis","Wer"};
	private String[] hour = { "07", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"}; 
	private String[] min = {"00", "10","20","30","40","50"};
	private String[] colNames = {"Von", "Bis","Wer"};
	private Object[][] data = {
			{"08:15", "13:00" , "Mr. Jim"},
			{"16:15", "17:00" , "Mr. Jim"}};

		
	public UserView() {
		super();
		//FrameOptions
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(900, 600));
		this.setLocationRelativeTo(null);
		this.setTitle("Raumbuchung");
		
		//ComboOption
		//cbEtage = new JComboBox<String>(etage);
		cbRoom = new JComboBox<String>(room);
		cbVonH = new JComboBox<String>(hour);
		cbVonM = new JComboBox<String>(min);
		cbBisH = new JComboBox<String>(hour);
		cbBisM = new JComboBox<String>(min);
		
		//Combobox setten �ber db
		cbEtage = new JComboBox<String>();
		ResultSet rs;
		try{
			rs = UserViewController.getInstance().getAllEtage();
			cbEtage.addItem(rs.getString(1));
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		}
		
		//LabelOption
		lblEtage = new JLabel("Etage:");
		lblRoom = new JLabel("Raum:");
		lblVon = new JLabel("Reservierung von:");
		lblBis = new JLabel("Reservierung bis:");
		
		//TableOption
		tUbersicht = new JTable(data, colNames);
		
		//PanelAnordnung			
		JPanel raumbelegung = new JPanel(new FlowLayout());
		raumbelegung.add(lblEtage);
		raumbelegung.add(cbEtage);
		raumbelegung.add(lblRoom);
		raumbelegung.add(cbRoom);
		
		JPanel oben = new JPanel(new BorderLayout());
		oben.add(raumbelegung, BorderLayout.WEST);
		oben.add(tUbersicht, BorderLayout.EAST);

		JPanel unten = new JPanel(new FlowLayout());
		unten.add(lblVon);
		unten.add(cbVonH);
		unten.add(cbVonM);
		unten.add(lblBis);
		unten.add(cbBisH);
		unten.add(cbBisM);
		
		JPanel allPanel = new JPanel(new BorderLayout());
		allPanel.add(oben, BorderLayout.NORTH);
		allPanel.add(unten, BorderLayout.SOUTH);
		
		this.add(allPanel);
	}
}
