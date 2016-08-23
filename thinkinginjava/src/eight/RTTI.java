package eight;
class Userful{
	public void f(){}
	public void g(){}
}
class MoreUserful extends Userful{
	public void f(){}
	public void g(){}
	public void u(){}
	public void v(){}
	public void w(){}
}
public class RTTI {
public static void main(String[] args) {
	Userful[] x={new Userful(),new MoreUserful()};
	x[0].f();
	x[1].g();
	((MoreUserful)x[1]).u();
	((MoreUserful)x[0]).u();
}
}
