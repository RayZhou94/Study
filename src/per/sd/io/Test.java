package per.sd.io;

class Demo{
	void demo1(){
		System.out.println("demo1...");
	}
	void demo2(){
		System.out.println("demo2...");
	}
}
public class Test extends Demo{
	private int a = 1;
//	void demo1(){
//	}
	void demo2(){
		System.out.println("Test demo2...");
	}
	void demo3(){
		System.out.println("Test demo3...");
	}
	public static void main(String[] args) {
		Demo demo = new Test();
		demo.demo1();
	}
}
