package ex07_override;

public class EspressoMain {

	public static void main(String[] args) {
		
		Espresso espresso =new Espresso(); 
		espresso.taste();
		
		Americano americano = new Americano();
		americano.taste();
		
		CafeLatte cafelatte = new CafeLatte();
		cafelatte.taste();

	}

}
