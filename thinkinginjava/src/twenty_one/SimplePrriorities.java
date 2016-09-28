package twenty_one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePrriorities implements Runnable {
private int countDown=5;
private int priority;
private volatile double d;
public SimplePrriorities(int priority){
this.priority=	priority;
}
public String toString(){
	return Thread.currentThread()+": "+countDown;
}
public void run(){
	Thread.currentThread().setPriority(priority);
	while(true){
		for(int i=1;i<100000;i++){
			d+=(Math.PI+Math.E)/(double)i;
			if(i%1000==0)
				Thread.yield();
		}
		System.out.println(this);
		if(--countDown==0) return ;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exec.execute(new SimplePrriorities(Thread.MIN_PRIORITY));
		exec.execute(new SimplePrriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
	}

}
