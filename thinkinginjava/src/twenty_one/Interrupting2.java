package twenty_one;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutex{
	private Lock lock=new ReentrantLock();
	public BlockedMutex(){
		lock.lock();
	}
	public void f(){
	try {
		lock.lockInterruptibly();
	} catch (InterruptedException e) {
	System.out.println("Interrupted from lock acqulsition in f()");
	}	
	}
}
class Blocked2 implements Runnable{
	BlockedMutex blocked=new BlockedMutex();
	public void run(){
		System.out.println("Waiting for f() in blockedmutex");
		blocked.f();
		System.out.println("Broken out of blocked call");
	}
}
public class Interrupting2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Thread t=new Thread(new Blocked2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Issuing t.interrupt()");
		t.interrupt();
	}

}
