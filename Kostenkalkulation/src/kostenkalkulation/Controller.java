package kostenkalkulation;

import javax.swing.*;

public class Controller {

	private double fixcostInput;
	private double varcostInput;
	private int personInput;
	private GUI gui;
	
	public Controller() {
		createGUI();
	}
	
	public void createGUI() {
		gui = new GUI();
		gui.createWindow(700, 500);
		gui.createLabels(150, 20, 50);
		gui.createTextFields(150, 20, 50);
	}
	
	public void clickCalc(JButton calculate) {
		
	}
	
	public void clickExit(JButton exit) {
		System.exit(0);
	}
	
	public void clickNewEntry(JButton newEntry) {
		
	}
	
	public void clickDeleteEntry(JButton delEntry) {
		
	}
	
	public void getInputFromGUI(GUI gui) {
		
	}
}
