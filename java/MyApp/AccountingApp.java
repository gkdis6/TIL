
public class AccountingApp {

	public static void main(String[] args) {

		double valueOfSupply = 10000.0;
		double[] dividendRates = new double[3]; //3개가 들어갈 수 있는 더블형 그릇
		dividendRates[0] = 0.5;
		dividendRates[1] = 0.3;
		dividendRates[2] = 0.2;
		
		System.out.println("Value of supply : "+valueOfSupply);
		System.out.println("vat : "+ (valueOfSupply*0.1) );
		System.out.println("Total : "+ (valueOfSupply + valueOfSupply*0.1));
		System.out.println("Expense : "+ (valueOfSupply*0.3));
		System.out.println("Income : "+ (valueOfSupply*0.7));
		System.out.println("Dividend : "+ (valueOfSupply*0.7*dividendRates[0]));
		System.out.println("Dividend : "+ (valueOfSupply*0.7*dividendRates[1]));
		System.out.println("Dividend : "+ (valueOfSupply*0.7*dividendRates[2]));
	}

}
