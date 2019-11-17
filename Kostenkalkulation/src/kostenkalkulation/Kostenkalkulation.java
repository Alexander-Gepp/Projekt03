package kostenkalkulation;

public class Kostenkalkulation {
	
	public static double calcPerPersonPrice(double fixcost, double varcost, int person) throws ArithmeticException {
		if(person <= 0)
			throw new ArithmeticException();
		
		return fixcost + (varcost * person) / person;
	}
}
