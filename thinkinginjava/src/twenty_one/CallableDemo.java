package twenty_one;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id){
		this.id=id;
	}
	public String call(){
		return "result of taskwithresult "+id;
	}
}
public class CallableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec=Executors.newCachedThreadPool();
		ArrayList<Future<String>> results=
				new ArrayList<Future<String>>();
		for(int i=0;i<10;i++)
			results.add(exec.submit(new TaskWithResult(i)));
		for(Future<String> fs:results)
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}finally{
				exec.shutdown();
			}
	}

}
