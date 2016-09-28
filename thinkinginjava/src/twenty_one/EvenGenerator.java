package twenty_one;

public class  EvenGenerator extends IntGenerator{
private int currentEvenValue=0;
public int next(){
	++currentEvenValue;
	++currentEvenValue;
	return currentEvenValue;
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenChecker.test(new EvenGenerator());
	}

}
