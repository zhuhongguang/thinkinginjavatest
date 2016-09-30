package twenty_one;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ActiveObjectDemo {
	private ExecutorService ex = Executors.newCachedThreadPool();
	private Random rand = new Random(47);

	private void pause(int factor) {
		try {
			TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("sleep() interrupted");
		}
	}

	public Future<Integer> calculateInt(final int x,final int y){
		return ex.submit(new Callable<Integer>() {
			public Integer call(){
				System.out.println(" starting " + x +" + "  + y);
				pause(2000);
				return x+y;
			}
		});
	}

	public Future<Float> calculateFloat(final Float x,final Float y){
		return ex.submit(new Callable<Float>() {
			public Float call(){
				System.out.println(" starting " + x +" + "  + y);
				pause(2000);
				return x+y;
			}
		});
	}
	/**
	 * @param args
	 */
	public void shutdown(){ex.shutdown();}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActiveObjectDemo d1=new ActiveObjectDemo();
		List<Future<?>> results=new CopyOnWriteArrayList<Future<?>>();
		for(float f=0.0f;f<1.0f;f+=0.2f)
			results.add(d1.calculateFloat(f, f));
		for(int i=0;i<5;i++)
			results.add(d1.calculateInt(i, i));
		System.out.println("All asynch calls made");
		while(results.size()>0){
			for(Future<?> f:results)
				if(f.isDone()){
					try {
						System.out.println(f.get());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new RuntimeException(e);
					} 
					results.remove(f);
				}
		}
		d1.shutdown();
	}

}
