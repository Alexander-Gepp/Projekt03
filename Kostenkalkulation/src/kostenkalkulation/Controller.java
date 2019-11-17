package kostenkalkulation;

import java.sql.SQLException;
import java.util.InputMismatchException;

import javax.swing.*;

public class Controller {

	private static double fixcostInput;
	private static double varcostInput;
	private static int personInput;
	private static GUI gui;
	
	public Controller() {
		createGUI();
		createDB();
	}
	
	public void createGUI() {
		gui = new GUI();
		gui.createWindow(700, 500);
		gui.createLabels(150, 20, 50);
		gui.createTextFields(150, 20, 50);
		gui.createDBList(600, 150, 50);
		gui.createButtons(150, 30, 20);
		
		gui.getPanel().repaint();
	}
	
	public void createDB() {
		connectToDatabase();
	}
	
	public static void clickCalc(JButton calculate) {
		getInputFromGUI(gui);
	}
	
	public static void clickExit(JButton exit) {
		System.exit(0);
		try {
			Database.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clickNewEntry(JButton newEntry) {
		
	}
	
	public static void clickDeleteEntry(JButton delEntry) {
		
	}
	
	private static void getInputFromGUI(GUI gui) {
		try {
			fixcostInput = Double.parseDouble(gui.getFixCostTxt().getText());
			varcostInput = Double.parseDouble(gui.getVarCostTxt().getText());
			personInput = Integer.parseInt(gui.getPersonTxt().getText());
		}catch(NumberFormatException e) {
			if(gui.getFixCostTxt().getText().isEmpty() || gui.getVarCostTxt().getText().isEmpty() 
			|| gui.getPersonTxt().getText().isEmpty()) {
				JOptionPane.showConfirmDialog(null, "Es wurde bei mindestens einem Feld nichts eingetragen", "Fehlermeldung",
											  JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showConfirmDialog(null, "Es wurde ein falscher Datentyp eingetragen", "Fehlermeldung",
						  JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}
		}		
	}
	
	public static void connectToDatabase() {
		try {
			Database.createDatabaseConnection("localhost", "3306", "kostenkalkulation", "root", "");
		}catch(SQLException sqle) {
			JOptionPane.showConfirmDialog(null, "Verbindung fehlgeschlagen! Überprüfen Sie, ob die DB online ist", "Fehlermeldung",
					  JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}catch(ClassNotFoundException cnfe) {
			JOptionPane.showConfirmDialog(null, "Treiber nicht gefunden", "Fehlermeldung",
					  JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void dbOutputRoom(JTextArea dblist) {
		dblist.setText("");
		try {
			dblist.setText(Database.createStatementRoom("select * from raeume"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dbOutputVarCost(JTextArea dblist) {
		dblist.setText("");
		try {
			dblist.setText(Database.createStatementVarCost("select * from varkosten"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
