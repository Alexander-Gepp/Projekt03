package kostenkalkulation;

import java.sql.SQLException;
import java.util.InputMismatchException;

import javax.swing.*;

public class Controller {

	private static int fixcostInput;
	private static int varcostInput;
	private static int personInput;
	private static double discountInput;
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
		calculateResult();
	}
	
	public static void clickExit(JButton exit) {
		//Schließt die DB Connection und beendet das Programm
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
		//Holt sich die Werte aus GUI und prüft auf ihre Korrektheit
		try {
			fixcostInput = Integer.parseInt(gui.getFixCostTxt().getText());
			varcostInput = Integer.parseInt(gui.getVarCostTxt().getText());
			personInput = Integer.parseInt(gui.getPersonTxt().getText());
			discountInput = Double.parseDouble(gui.getDiscountTxt().getText());
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
		//Holt sich alle Werte aus der Raumtabelle und gibt sie an der DB-Ausgabe aus
		dblist.setText("");
		try {
			dblist.setText(Database.createStatementRoom("select * from raeume"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dbOutputVarCost(JTextArea dblist) {
		//Holt sich alle Werte aus der Varkosten-Tabelle und gibt sie an der DB-Ausgabe aus
		dblist.setText("");
		try {
			dblist.setText(Database.createStatementVarCost("select * from varkosten"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void calculateResult() {
		//Holt sich Daten aus der DB und verrechnet diese
		double fixcostPrice;
		double varcostPrice;
		double perperson;
		
		try {
			fixcostPrice = Database.getPricesOfRoom(fixcostInput);
			varcostPrice = Database.getPricesOfVarCost(varcostInput);
			
			perperson = Kostenkalkulation.calcPerPersonPrice(fixcostPrice, varcostPrice, personInput, discountInput);
			gui.getPerpersonLabel().setText(String.valueOf(perperson));
						
		}catch(SQLException sqle) {
			JOptionPane.showConfirmDialog(null, "Wert konnte nicht in der DB gefunden werden", "Fehlermeldung",
					  JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}catch(ArithmeticException ae) {
			JOptionPane.showConfirmDialog(null, "Personen ist kleiner oder gleich 0", "Fehlermeldung",
					  JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
}
