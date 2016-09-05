package eleven;

import java.util.ArrayList;

class Apple{
	private static long counter;
	private final long id=counter++;
	public long id(){return id;};
}
class Orange{}
public class ApplesAndOrange {
public static void main(String[] args) {
@SuppressWarnings("unchecked")
	ArrayList apples=new ArrayList();
	for(int i=0;i<3;i++)//{
		apples.add(new Apple());
		apples.add(new Orange());
//	}
	//apples.add(new Orange());
	for(int i=0;i<apples.size();i++)
		((Apple)apples.get(i)).id();
}
}
