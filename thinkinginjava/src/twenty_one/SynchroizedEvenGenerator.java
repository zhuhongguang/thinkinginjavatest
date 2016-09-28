package twenty_one;

public class SynchroizedEvenGenerator extends IntGenerator {
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
