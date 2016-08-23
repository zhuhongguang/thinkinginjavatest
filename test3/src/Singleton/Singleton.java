package Singleton;

	public class Singleton {
	    private static Singleton singleton = new Singleton();
	    private Singleton() {                                 
	        System.out.println("インスタンスを伏撹しました。");
	    }
	    public static Singleton getInstance() {
	        return singleton;
	    }
	}


