package kostenkalkulation;

public class Kostenkalkulation {
	
	public static double calcPerPersonPrice(double fixcost, double varcost, int person, double discount) throws ArithmeticException {
		//Berechnet den Pro Person Anteil aus
		if(person <= 0)
			throw new ArithmeticException();
		fixcost += (varcost * person) / person;
		
		return fixcost / 100 * (100 - discount) ;
	}
}
