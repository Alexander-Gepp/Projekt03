package Test_Cases;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.*;

class Test_Case_CorrectCalc {

	private double fixKosten = 0;
    private double varKosten = 0;
    private int personen = 0;
    private double properson = 0;
	
	void input() throws InputMismatchException {
		fixKosten = Input.getFixKosten();
		varKosten = Input.getVarKosten();
		personen = Input.getPersonen();
		Input.getScanner().close();
		
		System.out.println("\n" + fixKosten + "\n" +  varKosten + "\n" + personen);
	}
	
	@Test
	void correctCalculation() {
		
		input(); //liest User Input
		
		properson = (fixKosten + (varKosten * personen)) / personen;
		
		assertFalse(properson > (fixKosten + varKosten));
	}

}
