package hello;

public class StringOperators {
public static void main(String[] args) {
	int x=0,y=1,z=2;
	String s="x,y,z";
	System.out.println(s+x+y+z);
	System.out.println(x+" "+s);
	s+="����";
	System.out.println(s+(x+y+z));
	System.out.println(""+x);
}
}
