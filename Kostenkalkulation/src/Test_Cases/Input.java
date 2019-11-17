package Test_Cases;

import java.util.Scanner;

public class Input {

//	private static double fixKosten = 0;
//    private static double varKosten = 0;
//    private static int personen = 0;
//    private static double properson = 0;
//    private static int programmstatus = 0;
//    private static int abfrage = 0;
	private static Scanner scan = new Scanner(System.in);
	
	public static double getFixKosten() {
		System.out.println("Fixkosteneingabe: ");
		return scan.nextDouble();
	}
	
	public static double getVarKosten() {
		System.out.println("Variable Kosteneingabe: ");
		return scan.nextDouble();
	}
	
	public static int  getPersonen() {
		System.out.println("Personeneingabe: ");
		return scan.nextInt();
	}
	
	public static Scanner getScanner() {
		return scan;
	}
}
