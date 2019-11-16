package kostenkalkulation;

import javax.swing.*;

public class Controller {

	private static double fixcostInput;
	private static double varcostInput;
	private static int personInput;
	private static GUI gui;
	
	public Controller() {
		createGUI();
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
	
	public static void clickCalc(JButton calculate) {
		getInputFromGUI(gui);
	}
	
	public static void clickExit(JButton exit) {
		System.exit(0);
	}
	
	public static void clickNewEntry(JButton newEntry) {
		
	}
	
	public static void clickDeleteEntry(JButton delEntry) {
		
	}
	
	private static void getInputFromGUI(GUI gui) {
		fixcostInput = Double.parseDouble(gui.getFixCostTxt().getText());
		varcostInput = Double.parseDouble(gui.getVarCostTxt().getText());
		personInput = Integer.parseInt(gui.getPersonTxt().getText());
		
		System.out.println(fixcostInput);
		
		
	}
}
