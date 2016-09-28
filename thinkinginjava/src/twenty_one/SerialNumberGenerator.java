package twenty_one;

public class SerialNumberGenerator extends IntGenerator{
private int currentEvenValue=0;
public synchronized int next(){
	++currentEvenValue;
	Thread.yield();
	++currentEvenValue;
	return currentEvenValue;
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenChecker.test(new SynchroizedEvenGenerator());
	}

}
