package kostenkalkulation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	}
	
	public void createDBList(int width, int height, int offset) {
		databaseTxtList = new JTextArea();
		
		databaseTxtList.setBounds(offset, (int)databaseLabel.getBounds().getY() + databaseLabel.getHeight() + 10, 
								  width, height);
		
		panel.add(databaseTxtList);
	}
	
	public void createButtons(int width, int height, int offset) {
		calcButton = new JButton("Berechnen");
		exitButton = new JButton("Beenden");
		newEntryButton = new JButton("neue Eintrag");
		deleteEntryButton = new JButton("Eintrag löschen");
		
		calcButton.setBounds(offset, window.getHeight() - 150, width, height);
		exitButton.setBounds((int)calcButton.getBounds().getX() + offset + width, 
							 window.getHeight() - 150, width, height);
		newEntryButton.setBounds((int)exitButton.getBounds().getX() + offset + width, 
								 window.getHeight() - 150, width, height);
		deleteEntryButton.setBounds((int)newEntryButton.getBounds().getX() + offset + width, 
									window.getHeight() - 150, width, height);
		
		panel.add(calcButton);
		panel.add(exitButton);
		panel.add(newEntryButton);
		panel.add(deleteEntryButton);
		
		createButtonActions();
	}	
	
	private void createButtonActions() {
		calcButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controller.clickCalc(calcButton);
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controller.clickExit(exitButton);
			}
		});
		
		newEntryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controller.clickNewEntry(newEntryButton);
			}
		});
		
		deleteEntryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controller.clickDeleteEntry(deleteEntryButton);
			}
		});
		
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public JTextField getFixCostTxt() {
		return fixcostTxt;
	}
	
	public JTextField getVarCostTxt() {
		return varcostTxt;
	}
	
	public JTextField getPersonTxt() {
		return personTxt;
	}
}
