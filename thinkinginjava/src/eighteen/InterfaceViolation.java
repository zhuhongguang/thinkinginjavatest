package eighteen;
class B implements A{
	public void f(){System.out.println("bf");}
	public void g(){System.out.println("bg");}
}
public class InterfaceViolation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new B();
		a.f();
		System.out.println(a.getClass().getName());
		if(a instanceof B){
			B b=(B)a;
			b.g();
		}
	}

}
