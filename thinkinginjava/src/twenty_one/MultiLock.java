package twenty_one;

public class MultiLock {
public synchronized void f1(int count){
	if(count-->0){
		System.out.println("f1() calling f2() wiht count "+count);
		f2(count);
	}
}
public synchronized void f2(int count){
	if(count-->0){
		System.out.println("f2() calling f1() with count "+count);
		f1(count);
	}
}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		final MultiLock multiLock=new MultiLock();
		new Thread(){
			public void run(){
				multiLock.f1(10);
			}
		}.start();
	}

}
