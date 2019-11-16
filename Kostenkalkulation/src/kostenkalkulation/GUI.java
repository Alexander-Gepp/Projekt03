package kostenkalkulation;

import java.awt.Color;

import javax.swing.*;

public class GUI {

	private JFrame window;
	private JPanel panel;
	private JLabel fixcostLabel;
	private JLabel varcostLabel;
	private JLabel personLabel;
	private JLabel databaseLabel;
	private JTextField fixcostTxt;
	private JTextField varcostTxt;
	private JTextField personTxt;
	private JTextArea databaseTxtList;
	private JButton calcButton;
	private JButton exitButton;
	private JButton newEntryButton;
	private JButton deleteEntryButton;
	
	public GUI() {
		
	}
	
	public void createWindow(int width, int height) {
		window = new JFrame();
		panel = new JPanel();
		
		window.setSize(width, height);
		window.setTitle("Kostenkalkulation");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		window.setContentPane(panel);
		
		panel.setLayout(null);
	}
	
	public void createLabels(int width, int height, int offset) {
		fixcostLabel = new JLabel("Fixkosten:");
		varcostLabel = new JLabel("Variable Kosten:");
		personLabel = new JLabel("Personen:");
		databaseLabel = new JLabel("Datenbankausgabe");
		
		databaseLabel.setBounds(offset, 10, width, height);
		fixcostLabel.setBounds(offset, window.getHeight() - 280, width, height);
		varcostLabel.setBounds((int)fixcostLabel.getBounds().getX() + offset + width, window.getHeight() - 280, 
							   width, height);
		personLabel.setBounds((int)varcostLabel.getBounds().getX() + offset + width, window.getHeight() - 280,
							  width, height);
		
		panel.add(fixcostLabel);
		panel.add(varcostLabel);
		panel.add(personLabel);
		panel.add(databaseLabel);
		panel.repaint();
		
	}
	
	public void createTextFields(int width, int height, int offset) {
		fixcostTxt = new JTextField();
		varcostTxt = new JTextField();
		personTxt = new JTextField();
		
		fixcostTxt.setBounds(offset, (int)fixcostLabel.getBounds().getY() + fixcostLabel.getHeight(),
							 width, height);
		varcostTxt.setBounds((int)fixcostTxt.getBounds().getX() + offset + width, 
							 (int)fixcostLabel.getBounds().getY() + fixcostLabel.getHeight(),
							 width, height);
		personTxt.setBounds((int)varcostTxt.getBounds().getX() + offset + width, 
							 (int)fixcostLabel.getBounds().getY() + varcostLabel.getHeight(),
							 width, height);
		
		panel.add(fixcostTxt);
		panel.add(varcostTxt);
		panel.add(personTxt);
		
		panel.repaint();
	}
	
	public void createDBList(int width, int height) {
		
	}
	
	public void createButtons(int width, int height) {
		
	}	
}
