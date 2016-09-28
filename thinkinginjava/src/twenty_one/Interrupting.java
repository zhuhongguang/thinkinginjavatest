package twenty_one;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleeBlocked implements Runnable{
	public void run(){
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("InterruptedException");
		}
		System.out.println("Exiting SleepBlocked.run()");
	}
}
class IOBlocked implements Runnable{
	private InputStream in;
	public IOBlocked(InputStream is){
		in=is;
	}
	public void run(){
	try {
		System.out.println("Waiting for read():");
		in.read();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		if(Thread.currentThread().isInterrupted()){
		e.printStackTrace();}
		else{
			throw new RuntimeException(e);
		}
	}
	System.out.println("Exinting IOBlocked.run()");
	}
}
class SynchronizedBlocked implements Runnable{
	public synchronized void f(){
		while(true)
			Thread.yield();
	}
	public SynchronizedBlocked(){
		new Thread(){
			public void run(){
				f();
			}
		}.start();
	}
	public void run(){
		System.out.println("Trying to call f()");
		f();
		System.out.println("Exiting SynchronizedBlocked.run()");
	}
}
public class Interrupting {
	private static ExecutorService exec=Executors.newCachedThreadPool();
	static void test(Runnable r)throws InterruptedException{
		Future<?> f=exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting "+r.getClass().getName());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		test(new SleeBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aborting with sysout.exit(0)");
		System.exit(0);
	}

}
